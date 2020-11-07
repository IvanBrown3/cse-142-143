import java.util.*; 
//Ivan Brown
//11/4/20
//TA: CC Sent
//This program will let a user play the Guessing Game. The program
//begins with a haiku, that gives a brief description of the game. 
//The game then begins and a random number is selected by the 
//program. User inputs a value until they guess the number.

public class GuessingGame {
    public static final int MAX_VALUE = 100;
    //creates new scanner object for user to input number
    //creates random object that generates random number
    //prints haiku
    //intializes the amount of games, total guesses and best guess 
    //decision to play game again if true
    //while loop allows program to play multiple games
    //prints report table passes the intializes values
    public static void main(String [] args){
        Scanner console = new Scanner(System.in);
        Random r = new Random();
        printHaiku();
        int gameCount = 0;
        int totalGuesses = 0;
        int bestGuesses=0;
        boolean decision = true;
        while(decision){
            gameCount++; //increases game count by 1 each loop
            int guessCount = playGame(r,console);
            totalGuesses += guessCount;
            if (gameCount == 1)
            {
                bestGuesses = guessCount;
            }
            else {
                if (guessCount < bestGuesses){
                    bestGuesses = guessCount;
                }
            }
            decision = playAgain(console);
        }
        reportTable(totalGuesses, gameCount, bestGuesses);
    }

    //prints out haiku
    public static void printHaiku(){
        System.out.println("Play this guessing game.");
        System.out.println("To get to the right result,");
        System.out.println("you will give your guess...");
        System.out.println();
    }

    //method to play a single game
    //passes random to create random number
    //passes scanner object to input value
    //lets user know if their value was higher or lower than random
    //returns the guess count after each game
    public static int playGame(Random r, Scanner console) {
        int randomNumber = r.nextInt(MAX_VALUE) + 1; //sets random value from 1-MAX_VALUE
        int personalNumber = 0; 
        int guessCount = 0;
        System.out.println("I'm thinking of a number between 1 and " + MAX_VALUE + "...");
        while(randomNumber !=  personalNumber){
            guessCount++;
            System.out.print("Your guess? "); 
            personalNumber = console.nextInt(); 
            if (personalNumber > randomNumber){
                System.out.println("It's lower.");
            }
            else if (personalNumber < randomNumber){
                System.out.println("It's higher.");
            }
        }
        if(guessCount == 1){
            System.out.println("You got it right in " + guessCount + " guess!");
        }
        else{
            System.out.println("You got it right in " + guessCount + " guesses!");
        }
        return guessCount;          //returns the guessCount each time a game is played
    }

    //method to play another game 
    //passes random object, scanner object as parameters to generate values
    //the program will play again if the user inputs any y in their answer 
    public static boolean playAgain(Scanner console){
        System.out.print("Do you want to play again? ");
        String pick = console.next();
        char first = pick.toLowerCase().charAt(0);
        System.out.println();
        return (first == 'y');          //returns true if y is inputed 
    }

    //rounding method to double any double to 1 decimal place
    public static double roundUp(double value){
        return Math.round(value * 10.0) / 10.0;
    }

    //method to create the report table
    //passes the guessCount, gameCount, bestGuesses as integer parameters
    //prints report table and statistics 
    public static void reportTable(int guessCount, int gameCount, int bestGuesses){
        System.out.println("Overall results:");
        System.out.println("Total games   = " + gameCount);
        System.out.println("Total guesses = " + guessCount);
        System.out.println("Guesses/game  = " + roundUp((double) guessCount/gameCount));
        System.out.println("Best game     = " + bestGuesses);
    }
}  

