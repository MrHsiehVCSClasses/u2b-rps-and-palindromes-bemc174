package u4pp;

/**
* JAVADOC HERE
*/
import java.util.Scanner;
public class RockPaperScissors {

    // Main method to run the game
    public static void play(Scanner sc){
        System.out.println("Welcome to Rock Paper Scissors");
        int wins = 0;
        int losses = 0;
        int ties = 0;
        boolean playAgain = true;

        // Loop to play multiple rounds
        while (playAgain == true){
            int result = playRound(sc);

            if (result == 0){
                ties++;
            } else if (result == 1){
                wins++;
            } else {
                losses++;
            }
            // print updated score
            System.out.println("You have " + wins + " wins and " + losses + " losses and " + ties + " ties");
            playAgain = getYesNoInput(sc, "Would you like to play again? (y)es or (n)o: ");
        }
    System.out.println("Thanks for playing!");
}


    /**
     * JAVADOC HERE
     */
    // Returns 1 if player wins, -1 if computer wins, 0 for tie
    public static int results(String playerChoice, String computerChoice) {
        playerChoice = playerChoice.toUpperCase();
        computerChoice = computerChoice.toUpperCase();
        if (playerChoice.equals(computerChoice)){
            return 0;
        } 
        else if ((playerChoice.equals("S") && computerChoice.equals("P")) || 
            (playerChoice.equals("P") && computerChoice.equals("R")) || 
            (playerChoice.equals("R") && computerChoice.equals("S"))) {
            return 1;
        } 
        else {
            return -1;
    }
}
    /* 
     * Helper methods for part b
     * These should be private static methods that help organize your code
     * 
     * Recommended helper methods:
     * 1. getRandomChoice() - returns a random "r", "p", or "s"
     * 2. getPlayerChoice(Scanner sc) - prompts user and returns valid R/P/S/A input
     * 3. getYesNoInput(Scanner sc, String prompt) - prompts user and returns true/false for Y/N
     * 4. playRound(Scanner sc, int[] scores) - handles one complete round of RPS
     * 5. formatChoice(String choice) - converts "r" to "Rock", "p" to "Paper", etc.
     */

     //gets a random choice for the computer and player
     private static String getRandomChoice() {
        int rand = (int)(Math.random() * 3);
        int choice = rand;
        if (choice == 0) return "R";
        if (choice == 1) return "P";
        return "S";
     }

        //gets the player's choice and validates it and sets to uppercase
    private static String getPlayerChoice(Scanner sc) {
        while (true) {
            System.out.print("Would you like to play (R)ock, (P)aper, or (S)cissors or (A)ny: ");
            String input = sc.nextLine().toUpperCase();
            if (input.equals("R") || input.equals("P") || input.equals("S") || input.equals("A")) {
                return input;
            }
            System.out.println("Invalid input please try again");
        }
    }

    //gets the player's choice for continuing the game and validates it and sets to uppercase
    private static boolean getYesNoInput(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().toLowerCase();
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            System.out.println("Invalid Input, please try again");
        }
    }

    //plays one round of the game and returns the result
    private static int playRound(Scanner sc) {
        String playerChoice = getPlayerChoice(sc);
        if (playerChoice.equals("A")) {
            playerChoice = getRandomChoice();
        }
        String computerChoice = getRandomChoice();
        int result = results(playerChoice, computerChoice);

        if (result == 0) {
            System.out.println("You both picked " + formatChoice(playerChoice) + " It's a tie!");
        } else if (result == 1) {
            System.out.println("You picked " + formatChoice(playerChoice) + " and the Computer picked " + formatChoice(computerChoice) + ". You win!");
        } else {
            System.out.println("You picked " + formatChoice(playerChoice) + " and the Computer picked " + formatChoice(computerChoice) + ". You lose!");
        }
        return result;
    }

    //returns the full name of the choice
    private static String formatChoice(String choice) {
        if (choice.equals("R")) return "Rock";
        if (choice.equals("P")) return "Paper";
        return "Scissors";
    }
}
