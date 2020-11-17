// This program creates a mad-lib using a template and user input. The program displays
// a menu where the user can choose to create or view the mad-lib, or quit the program.
// If the user chooses to create, the program prompts for a mad-lib template as a .txt
// file and another .txt file to output the completed mad-lib. The program then prompts
// the user to enter specfic types of words to satisfy the mad-lib based on the <placeholder>
// in the template .txt file. It then prints the mad-lib into the output file the user inputed.
// The output file can be viewed using the view option in the menu. The program displays the
// menu again after a mad-lib is created or if it is viewed.
import java.util.*;
import java.io.*;
public class MadLibs {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      boolean start = true;
      introduction();
      while (start == true) {
         start = menu(console);
      }
   }
   
   // Prints out the introduction
   public static void introduction() {
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      System.out.println();
   }
   
   // Displays a menu that prompts the user to create or view the mad-lib, or quit
   //
   // Scanner console - the Scanner to be used for user input
   public static boolean menu(Scanner console) throws FileNotFoundException {
      System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
      String userChoice = console.nextLine().toUpperCase();
      if (userChoice.equals("C")) {
         create(console);
         return true;
      } else if (userChoice.equals("V")) {
         view(console);
         return true;
      } else if (userChoice.equals("Q")) {
         return false;
      } else {
         return true;
      }
   }
   // Creates the mad-lib by prompting the user for the input and output file, the words3
   // to fill the mad-lib, and replaces the placeholders in the output file with the
   // user-inputed words.
   //
   // Scanner console - the Scanner to be used for user input
   public static void create(Scanner console) throws FileNotFoundException {
      File inputFile = fileInput(console);
      System.out.print("Output file name: ");
      String userOutput = console.nextLine();
      PrintStream output = new PrintStream(new File(userOutput));
      System.out.println();
      Scanner file = new Scanner(inputFile);
      while (file.hasNextLine()) {
         String line = file.nextLine();
         Scanner scanLine = new Scanner(line);
         while (scanLine.hasNext()) {
            String token = scanLine.next();
            if (token.startsWith("<") && token.endsWith(">")) {
               String word = token.substring(1, token.length() - 1);
               char articleCheck = word.toLowerCase().charAt(0);
               String check = article(articleCheck);
               word = word.replace("-"," ");
               System.out.print("Please type " + check + " " + word + ": ");
               String answer = console.nextLine();
               output.print(answer + " ");
            } else {
               output.print(token + " ");
            }
         } 
         output.println();
      }
      System.out.println("Your mad-lib has been created!");
      System.out.println();
   }
   
   // Prompts the user for the input file until the an existing file is given
   //
   // Scanner console - the Scanner to be used for user input
   public static File fileInput(Scanner console) {
      System.out.print("Input file name: ");
      String userInput = console.nextLine();
      File inputFile = new File(userInput);
      while (!inputFile.exists()) {
         System.out.print("File not found. Try again: ");
         userInput = console.nextLine();
         inputFile = new File(userInput);
      }
      return inputFile;
   }
   
   // Prompts the user for the input file until an existing file is given then prints out
   // the contents of the file until no more lines exist
   //
   // Scanner console - the Scanner to be used for user input
   public static void view(Scanner console) throws FileNotFoundException {
      File inputFile = fileInput(console);
      Scanner out = new Scanner(inputFile);
      System.out.println();
      while (out.hasNextLine()) {
         String text = out.nextLine();
         System.out.println(text);
      }
      System.out.println();
   }
   
   // Checks if the place holder has a vowel and if so, prints out an "an" instead of an "a"
   //
   // char article - the first character of the word in the placeholder
   public static String article(char article) {
      String check = "a";
      if (article == 'a' || article == 'e' || article == 'i' || article == 'o' || article == 'u') {
         check = "an";
      }
      return check;
   }
}











