import java.util.*; 

public class GuessingGame {
    public static final int MAX_VALUE = 100;
    public static void main(String [] args){
        Scanner console = new Scanner(System.in);
        Random r = new Random();
        printHaiku();
        
        int gameCount = 0;
        int totalGuesses = 0;
        int bestGuesses  = 0;
        boolean decision = true;

        while(decision){
            gameCount++;
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
            decision = playAgain(r, console);
        }
        reportTable(totalGuesses, gameCount, bestGuesses);
    }

    public static void printHaiku(){
        System.out.println("Play this guessing game.");
        System.out.println("To get to the right result,");
        System.out.println("you will give your guess...");
        System.out.println();
    }

    public static int playGame(Random r, Scanner console) {
        int randomNumber = r.nextInt(MAX_VALUE) + 1;
        //System.out.print(randomNumber);
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
        return guessCount;
    }

    public static boolean playAgain(Random r, Scanner console){
        System.out.print("Do you want to play again? ");
        String pick = console.next();
        char first = pick.toLowerCase().charAt(0);
        System.out.println();
        
        return (first == 'y');
    }

    public static double roundUp(double value){
        return Math.round(value * 10.0) / 10.0;
    }

    public static void reportTable(int guessCount, int gameCount, int bestGuesses){
        System.out.println("Overall results:");
        System.out.println("Total games   = " + gameCount);
        System.out.println("Total guesses = " + guessCount);
        System.out.println("Guesses/game  = " + roundUp((double) guessCount/gameCount));
        System.out.println("Best game     = " + bestGuesses);
    }
}   

