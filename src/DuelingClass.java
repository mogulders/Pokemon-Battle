import java.util.ArrayList;
import java.util.Scanner;
//need to commentate better with println
//need to have more fail safes ie if a number not between 1-3 for choosing pokemon
//the healthpoints aren't decreasing and its outputting irregularly during battle
//next issue... the damage multiplier isnt equating when it was blatoise vs venusaur both had damage multipliers
//2AM the game double faints because the speed advantage isnt taken in between each move instead it just puts the code first
//lotsss of bugs to go through tomorrow
//to make it even mildly playable it will eventually need to be connected to a jlabel system.
//it needs to be more clear which pokemon is taking damage and using moves as far as user and computer
//computer pokemon is having the damage multiplier regardless??
//not asking for get type and speeed advantage

public class DuelingClass {
	
	ArrayList<Pokemon> player1 = new ArrayList<Pokemon>();
	ArrayList<Pokemon> computerDeck = new ArrayList<Pokemon>();
	Scanner keyboard = new Scanner(System.in);

	
	
	public static void main(String[] args) {
		// how do you know which pokemon from youre array youre playing especially since it wont go back into the same position?
		System.out.println("Welcome to the game of Pokemon. You and the computer will each get 6 Pokemon, each with 175 health." + 
		" The pokemon that gets to attack first is the Pokemon with the speed advantage. Speed advantage is the type reciprocal, in type draw the computer will go first.");
		 
		DuelingClass play = new DuelingClass();
		ArrayList<Pokemon> player1 = play.fillPlayerDeck();
		System.out.println("");
		ArrayList<Pokemon> computerdeck = play.fillComputerDeck();
		play.wholeBattle(player1, computerdeck);
		
		
	}
	
	//if i pass two pokemon ArrayLists in as parameters then i can put this into the game actions class statically and pass the computer and player 1 lists in?
	//may need to return two ArrayLists player1 and computer
	

	
	
	//the computers deck is randomly filled with pokemon
	public ArrayList<Pokemon> fillComputerDeck() {
		while(computerDeck.size()<6) {
		int computerResponse = (int) (Math.random()*3);
		if (computerResponse == 1){
			Charizard charizard = new Charizard();
			computerDeck.add(charizard);
		} else if (computerResponse == 2) {
			Blastoise blastoise = new Blastoise();
			computerDeck.add(blastoise);
		} else {
			Venusaur venusaur = new Venusaur();
			computerDeck.add(venusaur);
		}
		}
		for (Pokemon cell : computerDeck ) {
			System.out.println("Computer : " + cell);
		}
	return computerDeck;	
	}
	//fills user deck with pokemon
	public  ArrayList<Pokemon> fillPlayerDeck() {
		while (player1.size()<6) {
			System.out.println("Choose a pokemon to add to your deck. Enter: \n1 for Charizard \n2 for Blastoise \n3 for Venusaur ");
			int response = keyboard.nextInt();
				if (response == 1){
					System.out.println("You have chosen Charizard as your pokemon");
					Charizard charizard = new Charizard();
					player1.add(charizard);
				} else if (response == 2) {
					System.out.println("You have chosen Blastoise as your pokemon");
					Blastoise blastoise = new Blastoise();
					player1.add(blastoise);
				} else {
					System.out.println("You have chosen Venusaur as your pokemon");
					Venusaur venusaur = new Venusaur();
					player1.add(venusaur);
				}
		}
		for (Pokemon cell : player1) {
			System.out.println("Player 1 : " + cell);
		}
	return player1;
	}
	

	
	//user chooses what pokemon to lay in battle
	public Pokemon chooseUserPokemon(){
		System.out.println("Enter the number corresponding to the pokemon in your list you want to lay");
		int i = keyboard.nextInt()-1;
		Pokemon liveUserPokemon = player1.get(i);
		System.out.println(liveUserPokemon + " I choose you!");
		return liveUserPokemon;
	}
	
	//computer chooses what pokemon to lay in battle
	public Pokemon chooseComputerPokemon(){
		int i =(int) (Math.random() * computerDeck.size());
		Pokemon liveComputerPokemon = computerDeck.get(i);
		System.out.println( "Computer: " + liveComputerPokemon + " I choose you!");
		return liveComputerPokemon;
	}
	//user chooses move to use
	//stil doesnt incorporate the pp which means theres no incentive to use lower powerlevel move
	public void userChooseMove(Pokemon userPokemon) {
		userPokemon.getMoves();
		System.out.println("Enter 1 or 2 based on what move you want to use.");
		int userMoveChoice = keyboard.nextInt();
		int move;
		if (userMoveChoice == 1) {
			move = userPokemon.move1();
			userPokemon.setMove(move);
		} else {
			move = userPokemon.move2();
			userPokemon.setMove(move);
		}
	}
	//computer chooses move to use
	//still doesnt incorporate the PP which means theres no incentive to use lower powerlevel move
	public void computerChooseMove(Pokemon computerPokemon) {
		int computerMoveChoice = (int) Math.random()*2;
		int move;
		if (computerMoveChoice == 1) {
			move = computerPokemon.move1();
			computerPokemon.setMove(move);
		} else {
			move = computerPokemon.move2();
			computerPokemon.setMove(move);
		} 
	}
	
	//should i return a pokemon object? not have the null type advantages? and return a pokemon object that has the type advantage?
	
	//gets type and speed advantage for the battle
	public void getLiveTypeAdvantage(Pokemon userPokemon, Pokemon computerPokemon) {
		
		if(userPokemon.getType().equals("fire") && computerPokemon.getType().equals("leaf")) {
			//should this be userPokemon.getType() == "fire"
			userPokemon.setTypeAdvantage(true);
			computerPokemon.setTypeAdvantage(false);
			System.out.println("User has the type advantage");
			
		} else if (userPokemon.getType().equals("fire") && computerPokemon.getType().equals("water")) {
			
			userPokemon.setTypeAdvantage(false);
			computerPokemon.setTypeAdvantage(true);
			System.out.println("Computer has the type advantage");
			
		} else if(userPokemon.getType().equals("fire") && computerPokemon.getType().equals("fire")){
			
			userPokemon.setTypeAdvantage(false);
			computerPokemon.setTypeAdvantage(false);
			System.out.println("No type advantage");
			 
		} else if (userPokemon.getType().equals("water") && computerPokemon.getType().equals("fire")) {
			
			userPokemon.setTypeAdvantage(true);
			computerPokemon.setTypeAdvantage(false);
			System.out.println("User has the type advantage");
			
		} else if(userPokemon.getType().equals("water") && computerPokemon.getType().equals("leaf")) {
			
			userPokemon.setTypeAdvantage(false);
			computerPokemon.setTypeAdvantage(true);
			System.out.println("Computer has the type advantage");
			
		}  else if(userPokemon.getType().equals("water") && computerPokemon.getType().equals("water")) {
			
			userPokemon.setTypeAdvantage(false);
			computerPokemon.setTypeAdvantage(false);
			System.out.println("No type advantage");
			
		}  else if (userPokemon.getType().equals("leaf") && computerPokemon.getType().equals("water")) {
			
			userPokemon.setTypeAdvantage(true);
			computerPokemon.setTypeAdvantage(false);
			System.out.println("User has the type advantage");
			
		} else if (userPokemon.getType().equals("leaf") && computerPokemon.getType().equals("fire")) {
			
			userPokemon.setTypeAdvantage(false);
			computerPokemon.setTypeAdvantage(true);
			System.out.println("Computer has the type advantage");
			
		} else if (userPokemon.getType().equals("leaf") && computerPokemon.getType().equals("leaf")) {
			
			userPokemon.setTypeAdvantage(false);
			computerPokemon.setTypeAdvantage(false);
			System.out.println("No type advantage");
			
		} else {
			System.out.println("Type advantage error");
		}
	}
	
	//computer pokemon attacks user pokemon
	public void computerAttacks(Pokemon userPokemon, Pokemon computerPokemon) {
		int damage;
		int healthPoints;
		
		if(computerPokemon.hasTypeAdvantage == true) {
			damage = computerPokemon.getMove()*2;
			userPokemon.decreaseHP(damage);
			healthPoints = userPokemon.getNewHP();
			System.out.println(userPokemon +"'s now has "+ healthPoints +" left.");
		} else {
			damage = computerPokemon.getMove();
			userPokemon.decreaseHP(damage);
			healthPoints = userPokemon.getNewHP();
			System.out.println(userPokemon +"'s now has "+ healthPoints +" left.");
		}
	}
	//user pokemon attacks computer pokemon
	public void userAttacks(Pokemon userPokemon, Pokemon computerPokemon) {
		int damage;
		int healthPoints;
		
		if(userPokemon.hasTypeAdvantage == true) {
			damage = userPokemon.getMove()*2;
			computerPokemon.decreaseHP(damage);
			healthPoints = computerPokemon.getNewHP();
			System.out.println(computerPokemon +"'s now has "+ healthPoints +" left.");
		} else {
			damage = userPokemon.getMove();
			computerPokemon.decreaseHP(damage);
			healthPoints = computerPokemon.getNewHP();
			System.out.println(computerPokemon +"'s now has "+ healthPoints +" left.");
		}
	}
	
	//battles the live pokemon until one runs out of healthpoints and then removes that from the arraylist and then adds the non 0 one back in
	public void livePokemonBattle(Pokemon userPokemon, Pokemon computerPokemon) {
		while (userPokemon.getNewHP() > 0 && computerPokemon.getNewHP() > 0) {
			if (userPokemon.hasTypeAdvantage == true) {//this assumes that the computer has a  disadvanatage  and the method is proper and being checked at the right times {
				computerChooseMove(computerPokemon);
				userChooseMove(userPokemon);
				computerAttacks(userPokemon ,computerPokemon );
				//here will have to be where 2AM comment will have to be answered
				userAttacks(userPokemon , computerPokemon);
			} else {//this assumes that the user has a  disadvanatage  and the method is proper and being checked at the right times
				userChooseMove(userPokemon);
				computerChooseMove(computerPokemon);
				userAttacks(userPokemon , computerPokemon);
				//here will have to be where 2AM comment will have to be answered
				computerAttacks(userPokemon ,computerPokemon);
			}
			if (userPokemon.getHealthPoints() <= 0 ) {
				player1.remove(userPokemon);
				computerDeck.add(computerPokemon);
			} else {
				computerDeck.remove(computerPokemon);
				player1.add(userPokemon);
			}
		}
		if(userPokemon.getNewHP() <= 0) {
			System.out.println("User pokekmon " + userPokemon + "has fainted");
		} else {
			System.out.println("Computer pokekmon " + computerPokemon + "has fainted");
		}
	}

	public void wholeBattle(ArrayList<Pokemon> player1, ArrayList<Pokemon> computerDeck) {
		while (player1.size() >= 0 || computerDeck.size() >= 0) {
			Pokemon liveUserPokemon = chooseUserPokemon();//should say how much hp is left on chosen pokemon
			Pokemon liveComputerPokemon = chooseComputerPokemon();
			getLiveTypeAdvantage(liveUserPokemon, liveComputerPokemon);
			livePokemonBattle(liveUserPokemon, liveComputerPokemon);
			
			}
		
	}
}
