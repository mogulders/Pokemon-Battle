
import java.util.Scanner;

public class exercises {

	public static void main(String[] args) {
		 
	    
	    int question1;
	    char question1Check;
	    int question2;
	    char question2Check;
	    int question3;
	    char question3Check;
	    String reference = ("Sherlock would you like to play? Answer until you get a g. Guess a number.");
	    
	    
	    
	    System.out.println("Sherlock would you like to play? Answer until you get a g. Guess a number.");
	    Scanner oneR = new Scanner(System.in);
	    question1=oneR.nextInt();
	    question1Check = reference.charAt(question1);
	    
	    
	    

	    if ( question1Check == 'g')
	    System.out.println("I knew you were good but one try is elite. Sherlock Holmes you've always been quick on your feet.");
	    else
	    System.out.println("Sorry bum that is one. You answered with the letter " + question1Check + ". Sherlock would you like to play? Answer until you get a g. Guess a number.");
	    
	    
	    Scanner twoR = new Scanner(System.in);
	    question2 = twoR.nextInt();
	    question2Check = reference.charAt(question2);
	    
	    
	    if (question2Check == 'g')
	    System.out.println("Question two you're decent, as far as mortals go. But you still aren't... Sherlock Holmes");
	    else
	    System.out.println("number two, three and you lose. You answered with the letter " + question2Check + ". Sherlock would you like to play? Answer until you get a g. Guess a number.");
	    
	    Scanner threeR = new Scanner(System.in);
	    question3 = threeR.nextInt();
	    question3Check = reference.charAt(question3);
	    
	    if (question3Check == 'g')
	    System.out.println("Third is par, congrats on being average, but you're not Sherlock Holmes you're hardly even passin");
	    else
	    System.out.println("You've lost the game, please don't play again.");
	    
	    
	  } 
	  }