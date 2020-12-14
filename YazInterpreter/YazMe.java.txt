//This program will start the Yaz Lanugage interpreter.
//There are three yaz lang commands that are used to read input from
//a file and convert them to a new result in a new file. This conversion
//will be based on each commands function. 
//This program will also allow you to view what outputs to the file in the console.

import java.util.Scanner;
import java.io.*;
public class YazInterpreter {
   //Main method prints intoduction of the code and begins the program
   //Begins program and directs the user to either enter I V or Q
   //User will enter I to interpret the input file
   //user will enter V to view the output text in the console
   //user will enter Q to quit the program
   //adds throws FileNotFoundException
   //method creates an scanner to read the input
    public static void main(String[] args) throws FileNotFoundException{
        Scanner inputScanner = new Scanner(System.in);
        boolean quitProgram = false;
        System.out.println("Welcome to YazInterpreter!");
        System.out.println("You may interpret a YazLang program and output");
        System.out.println("the results to a file or view a previously");
        System.out.println("interpreted YazLang program.");
        System.out.println();
        //Loop until quit.
        while (!quitProgram){
            System.out.print("(I)nterpret YazLang program, (V)iew output, (Q)uit? ");
            //Read in option
            String option = inputScanner.nextLine().toLowerCase();
            //two main functional calls, if q then program quits
            if (option.equals("i")) 
                interpretFile(inputScanner);
            else if (option.equals("v"))
                viewResults(inputScanner);
            else if (option.equals("q"))
                quitProgram = true;
        }
    }

    //method to interpret the file if I is chosen in the menu
    //passes the scanner input as a parameter
    //adds throws file not found expection
    //method firts sets input and output files using input and output methods
    //while the scanner has a new line to process
    //if statements to indicate where to sent the line based on the argument.
    //else is if the command is not one of the special yazlang commands
    //closes the print stream which is done by flushing stream and closing
    public static void interpretFile(Scanner inputScanner) throws FileNotFoundException {
        // Get input file
        Scanner fileScanner =  getInputFileScanner(inputScanner);
        // Set output file
        PrintStream log = getLogger(inputScanner);
        // Read each line from Input
        while (fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            Scanner parseThrough = new Scanner(line);
            String command = parseThrough.next().toLowerCase();
            
            if (command.equals("convert")){
                log.println(convert(parseThrough));
            }
            else if (command.equals("range")){
                log.println(range(parseThrough));
            }
            else if (command.equals("repeat")){
                log.println(repeat(parseThrough));
            }
            else{
                //invalid command
            }
        }
        log.close();
        System.out.println("YazLang interpreted and output to a file!");
        System.out.println();

    }
    
    //static string method, takes Scanner as a parameter
    //method is told to conver the arguments when the main method reads the command
    //returns a new string of the the conversions
    public static String convert(Scanner fileScanner){
        String returnString = "";
        double tempNum = fileScanner.nextInt();
        String units = fileScanner.next();
        if(units.equalsIgnoreCase("f")){
            tempNum = (tempNum - 32) / 1.8;
            returnString = (int)(tempNum) + "C";
        }
        else if(units.equalsIgnoreCase("c")){
            tempNum = (tempNum * 1.8) + 32;
            returnString = (int)(tempNum) + "F";
        }
        return returnString;
    }
    
    //static string method for range command
    //returns a new string of the range conversions
    //passes the file Scanner as a parameter
    //uses the first three arguments of the argument to structure the loop
    //the arguments follow the pattern of start stop and increment
    public static String range (Scanner fileScanner){
        String returnString = "";
        int initial = fileScanner.nextInt();
        int stop = fileScanner.nextInt();
        int incre = fileScanner.nextInt();
        for (int i = initial; i < stop; i = i + incre){
            returnString += (i + " ");
        }
        return returnString;
    }

    //static method to use repeat command
    //passes scanner filsScanner as a parameter
    //method removes quotes, prints based on the number argument aquired
    //method replaces any underscore with a blank space
    //returns a string of the output of this function based on file input
    public static String repeat(Scanner fileScanner){
        String returnString = "";
        while (fileScanner.hasNext()) {
            String cnt = "";
            String term = fileScanner.next();
            if (term.charAt(0) == '\"'){
                term = term.substring(1, term.length()-1);
            }
            int repeatVal = fileScanner.nextInt();
            for (int i = 0 ;i < repeatVal; i++){
                cnt += term;
            }
            returnString += cnt.replace("_"," ");
        }
        return returnString;
    }

    //View Results, Takes input scanner from main
    //adds throws file not found excpetion
    //while loop that runs the scanner through each line, prints each line from scanner into console
    public static void viewResults(Scanner inputScanner) throws FileNotFoundException{
        // Get file
        Scanner fileScanner = getInputFileScanner(inputScanner);
        System.out.println();
        while (fileScanner.hasNextLine()){
            System.out.println(fileScanner.nextLine());
        }
        System.out.println();
    }

    //Print stream method that returns the printstream to output file
    //takes scanner as a parameter
    //called getLogger since it will be logging new converted output to the file
    //method adds throws file not found exeption
    //method adds throws FileNotFoundException
    public static PrintStream getLogger(Scanner inputScanner) throws FileNotFoundException{
        System.out.print("Output file name: ");
        String fileName = inputScanner.nextLine();
        return new PrintStream(new File(fileName));
    }

    //method that returns the the input of the file
    //takes the scanner input as a parameter
    //declared valid file as false
    //file storage is null, set to be the input of each line in the file
    //if not file exists then a file not found will be reported to console
    //while loop stops as soon as there are no more lines to read from the file 
    //method adds throws file not found expection
    public static Scanner getInputFileScanner(Scanner inputScanner) throws FileNotFoundException{
        boolean isValidFile = false;
        File file = null;
        System.out.print("Input file name: ");
        while (!isValidFile){
            String inputFile = inputScanner.nextLine();
            file = new File (inputFile);
            if (!file.exists()){
                System.out.print("File not found. Try again: ");
            }
            else{
                isValidFile = true;
            }
        }
        return new Scanner (file);
    }
}