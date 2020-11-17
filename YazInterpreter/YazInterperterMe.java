import java.util.Scanner;
import java.io.*;
public class YazInterperterMe {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner inputScanner = new Scanner(System.in);
        
    }
    
    //View Results, Takes input scanner from main
    //adds throws file not found excpetion
    //println for code output spacing
    //while loop that runs the scanner through each line, prints each line from scanner into console
    //println for code spacing
    public static void view (Scanner inputScanner) throws FileNotFoundExpection{
        Scanner fileScanner = getInputFileScanner(inputScanner);
        System.out.println();
        while(fileScanner.hasNextLine()){
            System.out.println(fileScanner.nextLine());
        }
        System.out.println();
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
    
    //Print stream method that returns the printstream to output file
    //takes scanner as a parameter
    //called getLogger since it will be logging new converted output to the file
    //method adds throws file not found exeption
    public static PrintStream getLogger(Scanner inputScanner) throws FileNotFoundException{
        System.out.println("Output file name: ");
        String fileName = inputScanner.nextLine();
        return new PrintStream (new File (fileName));
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
    public static void interpretFile(Scanner inputScanner) throws FileNotFoundException{
        Scanner fileScanner = getInputFileScanner(inputScanner);
        PrintStream log = getLogger(inputScanner);
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            String command = line.substring(0,indexOf(" ")).toLowerCase;
            String args = line.substring(0,indexOf(" ") + 1);
            if(command.equals("convert")){
                log.println(convert(args));
            }
            else if(command.equals("range")){
                log.println(range(args));
            }
            else if(command.equals("repeat")){
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
    public static void flowMethod(Scanner inputScanner) throws FileNotFoundException{
        boolean endProgram = false;
        while(!endProgram){
            System.out.print("(I)nterpret YazLang program, (V)iew output, (Q)uit? ");
            String option = inputScanner.nextLine().toLowerCase();
            if(option.equals("i"))
                interpretFile(inputScanner);
            
            else if(option.equals("v"))
                view(inputScanner);
            
            else if (option.equals("q"))
                endProgram = true;
            
        }
    }
}

