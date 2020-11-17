//This program will start the Yaz Lanugage interpreter.
//There are three yaz lang commands that are used to read input from
//a file and convert them to a new result in a new file. This conversion
//will be based on the commands function. 

import java.util.Scanner;
import java.io.*;
public class YazInterpreter {
   //Main method prints intoduction
   //Begins program and directs the user to either enter I V or Q.
   //Each with its respective fuctions.
    public static void main(String[] args) throws FileNotFoundException{

        System.out.println("Welcome to YazInterpreter!");
        System.out.println("You may interpret a YazLang program and output");
        System.out.println("the results to a file or view a previously");
        System.out.println("interpreted YazLang program.");
        System.out.println();

        Scanner inputScanner = new Scanner(System.in);
        boolean quitProgram = false;
        
        //Loop until quit.
        while (!quitProgram)
        {
            System.out.print("(I)nterpret YazLang program, (V)iew output, (Q)uit? ");
            //Read in option
            String option = inputScanner.nextLine().toLowerCase();
            //two main functional calls, if q then program quits
            if (option.equals("i")) 
                InterpretFile(inputScanner);
            else if (option.equals("v"))
                ViewResults(inputScanner);
            else if (option.equals("q"))
                quitProgram = true;
        }
    }

    //method to interpret the file if I is chosen in the menu
    //passes the scanner input as a parameter
    //adds throws file not found expection
    //method firts sets input and output files using input and output methods
    //while the scanner has a new line to process
    //if while true, then the line is set too the next line in the file
    //the command is found by going from the start of the line to where the first space is
    //sets to lowercase 
    //string args is set to the positon in the line where it finds the space and adds one to indicate that as an argument
    //if statements to indicate where to sent the line based on the argument.
    //else is if the command is not one of the special yazlang commands
    //closes the print stream which is done by flushing stream and closing
    public static void InterpretFile(Scanner inputScanner) throws FileNotFoundException {
        // Get input file
        Scanner fileScanner =  getInputFileScanner(inputScanner);
        // Set output file
        PrintStream log = getLogger(inputScanner);
        // Read each line from Input
        while (fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            String command = line.substring(0,line.indexOf(" ")).toLowerCase();  //CONVERT or RANGE start stop step REPEAT ARG Count
            String args = line.substring(line.indexOf(" ") + 1);
            
            if (command.equals("convert")){
                log.println(convert(args));
            }
            else if (command.equals("range")){
                log.println(range(args));
            }
            else if (command.equals("repeat")){
                log.println(repeat(args));
            }
            else{
                //invalid command

            }

        }
        log.close();
        System.out.println("YazLang interpreted and output to a file!");
        System.out.println();

    }

    public static String convert(String args){
        //If input was 212 F
        String returnString = "100 C";
        return returnString;
        
    }

    public static String range (String args){
        String returnString = "100 101 102";
        return returnString;
    }

    public static String repeat(String args){
        String returnString = "";
        //"Hello" 2 "World" 1
        String cnt;ww
        // chop off the term and cnt from the args then print the term (cnt) times
        while (args.length()>0) {
            //extract the term from the args
            String term = args.substring(0,args.indexOf(" "));
            
            //remove the Term from the args
            args = args.substring(args.indexOf(" ") + 1);
            if (args.indexOf(" ") > 0){
                //extract the cnt from the args
                cnt = args.substring(0, args.indexOf(" "));
                
                //Remove the cnt from the args
                args = args.substring(args.indexOf(" ")+1);
            }
            else {
                //No more terms after this since there are no more spaces
                cnt = args;
                args = "";
            }

            for (int i = 0 ;i<Integer.parseInt(cnt); i++){
                returnString += term.replace("\"", "").replace("_"," ");
            }
        }

        return returnString;
    }

    //View Results, Takes input scanner from main
    //adds throws file not found excpetion
    //while loop that runs the scanner through each line, prints each line from scanner into console
    public static void ViewResults(Scanner inputScanner) throws FileNotFoundException{
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
            //read in file name
            file = new File (inputScanner.nextLine());

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