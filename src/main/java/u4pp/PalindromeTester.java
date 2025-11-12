package u4pp;
/**
* YOUR COMMENTS HERE
*/
import java.util.Scanner;

public class PalindromeTester {
    /**
     * YOUR JAVADOC HERE
     */
    // Main method to run the palindrome tester program
    public static void execute(Scanner sc) {
      System.out.println("Welcome to the Palindrome Tester");
      boolean keepGoing = true;
      while (keepGoing) {
          System.out.print("Enter a phrase: ");
          String phrase = sc.nextLine();
          boolean pal = isPalindrome(phrase);
          if (pal) {
              System.out.println(phrase + " is a palindrome!");
          } else {
              System.out.println(phrase + " is not a palindrome.");
          }
          keepGoing = getYesOrNo(sc, "Keep testing? (Y)es or (N)o: ");
      }
    }

    /**
     * YOUR JAVADOC HERE
     */
    //Checks if the phrase is a palindrom is case insensitive and ignores non-letter characters
    public static boolean isPalindrome(String phrase) {
        String cleaned = cleanedToLowerCase(phrase);
        String reversed = reverseString(cleaned);
        return cleaned.equals(reversed);
    }

    // asks for a yes or no input and validates it
    public static boolean getYesOrNo(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }

    // removes non-letter characters and converts to lowercase
    private static String cleanedToLowerCase(String phrase) {
        String cleaned = "";
        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            if (Character.isLetter(c)) {
                cleaned += Character.toLowerCase(c);
            }
        }
        return cleaned;
    }

    // reverses the cleaned string
    private static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
}