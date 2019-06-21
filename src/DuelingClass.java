import java.util.ArrayList;
import java.util.Scanner;

//DEBUGGING IS FIGURING OUT WHAT YOURE ASSUMING AND FIXING IT


/*TO DO
*pp is the next layer to be added as of right now its a drawn out paper scissors and slight chance adding pp incentivises some sort of math
*i think the computer always selects ooption two for moves is because of the random number gen i think when its muliplied by 1 or two and casted to an int it always roudns up, so the if statements for computer chooses move needs to be 2 and 3 ( it doesnt and if i have tried 2 3 once and it didnt work)
*need a try catch on the choosing a pokemon for if a number larger than indexes is picked
*/


/*ANSWERED
 * a "12" selected a venusaur?(a number greater than the one attributed will select the last pokemon im ok with this fail safe)
 * and when it was zero left the game didnt end it ended in an exception(just had to change it to && instead of or and change to > not >=
 * do i make it baisically if type advantage win or a two shot instead of this weird 115 55 type shit lol(changed to 120 health and 40 60 move choice)
 * create a toStringNoHealthPoints to use during battle to fix weird "User Pokemon: Charizard: 55 fire's now has 55 left." problem
 * need to commentate better with println
 * it needs to be more clear which pokemon is taking damage and using moves as far as user and computer
 * not properly printing hp when called. I had two seperate hp variables being checke in the two string. i had a similar thing happen to the type during type advantag)
 * player 1 arraylist doesnt seem to dynamically shrink after a pokemon has fainted why?(it happens not sure why if i remember i had the fainted method in the attack method and it was checking a bunch of improper things referencee git hub closest to beginging of june with braden at meatballs)
 * fainting later in the game doesnt behave properly, I assume its due to the non working dynamically shrinking arraylist for some fuckin reason answered above
 * after the add back it makes a seventh object and the 7th and 1st object are the same maybe need to remove object and then add it back?! (when you select an object out of an ArrayList it isnt pulled from the list. you dont need to add it back then which i was previously doing)
 * all charizard hp objects updated when one took damage(fixed with adding and removing of object in a list)
 * when the array list of computer deck changes dynamically so does the random pokemon chooser?!?!(hasnt seemed to need to but that could be similar to the "12" selects a venusaur. maybe a number larger than the bounds selects the last? is this an ok fail safe and why)
 * add number iterator to the array list
 */

public class DuelingClass {
	
	ArrayList<Pokemon> player1 = new ArrayList<Pokemon>();
	ArrayList<Pokemon> computerDeck = new ArrayList<Pokemon>();
	Scanner keyboard = new Scanner(System.in);

	
	
	public static void main(String[] args) {
		// how do you know which pokemon from youre array youre playing especially since it wont go back into the same position?
		System.out.println("Welcome to the Mobile Mogul Pokemon Battle. You will battling a randomly generated Computer Pokemon deck in a 6 Pokemon battle. There is a x2 damage for type advantage. \n" + 
				"Type advantages are as follows:\n" + 
				"Fire>Leaf || Water>Fire || Leaf>Water\n" + 
				"Speed advantage will decide which Pokemon attacks first. Speed advantage is reciprocal of type advantage. If there is no type advantage the computer will go first.\n" + 
				"");
		 
		DuelingClass play = new DuelingClass();
		ArrayList<Pokemon> player1 = play.fillPlayerDeck();
		System.out.println("");
		ArrayList<Pokemon> computerdeck = play.fillComputerDeck();
		play.wholeBattle(player1, computerdeck);
		
		
	}
	
	
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
	return player1;
	}
	
	
	//user chooses what pokemon to lay in battle
	public Pokemon chooseUserPokemon(){
		for (Pokemon cell : player1) {
			System.out.println("Player 1 : " + cell);
			}
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
	
	
	//gets type and speed advantage for the battle
	public void getLiveTypeAdvantage(Pokemon userPokemon, Pokemon computerPokemon) {
		
		if(userPokemon.getType().equals("fire") && computerPokemon.getType().equals("leaf")) {
			//should this be userPokemon.getType() == "fire"
			userPokemon.setTypeAdvantage(true);
			computerPokemon.setTypeAdvantage(false);
			computerPokemon.goesFirst(true);
			System.out.println("User has the type advantage");
			System.out.println("The Computer attacks first.");
			
		} else if (userPokemon.getType().equals("fire") && computerPokemon.getType().equals("water")) {
			
			userPokemon.setTypeAdvantage(false);
			computerPokemon.setTypeAdvantage(true);
			userPokemon.goesFirst(true);
			System.out.println("Computer has the type advantage");
			System.out.println("The User attacks first.");
			
		} else if(userPokemon.getType().equals("fire") && computerPokemon.getType().equals("fire")){
			
			userPokemon.setTypeAdvantage(false);
			computerPokemon.setTypeAdvantage(false);
			computerPokemon.goesFirst(true);
			System.out.println("No type advantage");
			System.out.println("The Computer attacks first.");
			 
		} else if (userPokemon.getType().equals("water") && computerPokemon.getType().equals("fire")) {
			
			userPokemon.setTypeAdvantage(true);
			computerPokemon.setTypeAdvantage(false);
			computerPokemon.goesFirst(true);
			System.out.println("User has the type advantage");
			System.out.println("The Computer attacks first.");
			
		} else if(userPokemon.getType().equals("water") && computerPokemon.getType().equals("leaf")) {
			
			userPokemon.setTypeAdvantage(false);
			computerPokemon.setTypeAdvantage(true);
			userPokemon.goesFirst(true);
			System.out.println("Computer has the type advantage");
			System.out.println("The User attacks first.");
			
		}  else if(userPokemon.getType().equals("water") && computerPokemon.getType().equals("water")) {
			
			userPokemon.setTypeAdvantage(false);
			computerPokemon.setTypeAdvantage(false);
			computerPokemon.goesFirst(true);
			System.out.println("No type advantage");
			System.out.println("The Computer attacks first.");
			
		}  else if (userPokemon.getType().equals("leaf") && computerPokemon.getType().equals("water")) {
			
			userPokemon.setTypeAdvantage(true);
			computerPokemon.setTypeAdvantage(false);
			computerPokemon.goesFirst(true);
			System.out.println("User has the type advantage");
			System.out.println("The Computer attacks first.");
			
		} else if (userPokemon.getType().equals("leaf") && computerPokemon.getType().equals("fire")) {
			
			userPokemon.setTypeAdvantage(false);
			computerPokemon.setTypeAdvantage(true);
			userPokemon.goesFirst(true);
			System.out.println("Computer has the type advantage");
			System.out.println("The User attacks first.");
			
		} else if (userPokemon.getType().equals("leaf") && computerPokemon.getType().equals("leaf")) {
			
			userPokemon.setTypeAdvantage(false);
			computerPokemon.setTypeAdvantage(false);
			computerPokemon.goesFirst(true);
			System.out.println("No type advantage");
			System.out.println("The Computer attacks first.");
			
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
			System.out.println("User Pokemon: " + userPokemon.toStringDuringBattle() +" now has "+ healthPoints +" left.");
		} else {
			damage = computerPokemon.getMove();
			userPokemon.decreaseHP(damage);
			healthPoints = userPokemon.getNewHP();
			System.out.println("User Pokemon: " + userPokemon.toStringDuringBattle() +" now has "+ healthPoints +" left.");
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
			System.out.println("Computer Pokemon: " + computerPokemon.toStringDuringBattle() +" now has "+ healthPoints +" left.");
		} else {
			damage = userPokemon.getMove();
			computerPokemon.decreaseHP(damage);
			healthPoints = computerPokemon.getNewHP();
			System.out.println("Computer Pokemon: " + computerPokemon.toStringDuringBattle() +" now has "+ healthPoints +" left.");
		}
	}
	
	public void checkFainted(Pokemon userPokemon, Pokemon computerPokemon) {
		if (userPokemon.getNewHP() <= 0 && computerPokemon.getNewHP()>=0 ) {
			player1.remove(userPokemon);
			userPokemon.hasFainted(true);
			System.out.println("User pokekmon " + userPokemon + " has fainted");
		} else if(computerPokemon.getNewHP() <= 0 && userPokemon.getNewHP() >=0) {
			computerDeck.remove(computerPokemon);
			computerPokemon.hasFainted(true);
			System.out.println("Computer pokekmon " + computerPokemon + " has fainted");
		} else {
			
		}
	}
	
	//battles the live pokemon until one runs out of healthpoints and then removes that from the arraylist and then adds the non 0 one back in
	public void livePokemonBattle(Pokemon userPokemon, Pokemon computerPokemon) {
		while (userPokemon.getNewHP() > 0 && computerPokemon.getNewHP() > 0) {

			
			if (userPokemon.goesFirst == false) { 
				computerChooseMove(computerPokemon);
				computerAttacks(userPokemon,computerPokemon);
				checkFainted(userPokemon,computerPokemon);
				if(userPokemon.hasFainted==true) {
					break;
				}
				else {
				userChooseMove(userPokemon);
				userAttacks(userPokemon,computerPokemon);
				checkFainted(userPokemon,computerPokemon);}
				
			} else {
				userChooseMove(userPokemon);
				userAttacks(userPokemon,computerPokemon);
				checkFainted(userPokemon,computerPokemon);
				if(computerPokemon.hasFainted==true) {
					break;
				} else {
				computerChooseMove(computerPokemon);
				computerAttacks(userPokemon,computerPokemon);
				checkFainted(userPokemon,computerPokemon);
				}
			}	
			
		}
		
	}
		 
		
	//executest the full battle
	public void wholeBattle(ArrayList<Pokemon> player1, ArrayList<Pokemon> computerDeck) {
		while (player1.size() > 0 && computerDeck.size() > 0) {
			
			System.out.println(">>> Choose");
			System.out.println(">>> Next");
			System.out.println(">>> Pokemon");
			
			Pokemon liveUserPokemon = chooseUserPokemon();//should say how much hp is left on chosen pokemon
			Pokemon liveComputerPokemon = chooseComputerPokemon();
			getLiveTypeAdvantage(liveUserPokemon,liveComputerPokemon);
			livePokemonBattle(liveUserPokemon,liveComputerPokemon);
			
			}
		if (player1.size() == 0) {
			System.out.println("All of your Pokemon have fainted. You lose.");
		} else {
			System.out.println("You have defeated the computer. Here is your Mobile Mogul Badge");
		}
	}
}
