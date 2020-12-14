//Ivan Brown
//12/11/20
//TA: CC Sent 
//This program will take in a file of a personality test results and for each person
//will produce a code of the personality type that they ar in. The program will
//output the result to a new file. This program will promt the user to enter and input 
//file location and an output file location

import java.util.*;
import java.io.*;
public class Personality {
    public static final int ARRAY_CONSTANT = 4;
    public static final String[] A_OUTCOMES = { "E", "S", "T", "J" };
    public static final String[] B_OUTCOMES = { "I", "N", "F", "P" };
    
    //main method that gets input from a file using a Scanner
    //creates location where the output file will be 
    //main method controls the flow of the method using a while loop
    //while loop checks if the file has a next line to read
    public static void main(String[] args) throws FileNotFoundException {
        int[] bPercent = new int [ARRAY_CONSTANT];
        intro();
        Scanner inputScanner = new Scanner(System.in);
        Scanner fileScanner = getInputFileScanner(inputScanner);
        PrintStream log = getLogger(inputScanner);
        while (fileScanner.hasNextLine()) {
            String name = fileScanner.nextLine();
            String line = fileScanner.nextLine();
            int[] aResponse = processResponses(line, 'A');
            int[] bResponse = processResponses(line, 'B');
            for (int i = 0; i < ARRAY_CONSTANT; i++) {
                bPercent[i] = 
                (int) Math.round(100.0 * bResponse[i] / (aResponse[i] + bResponse[i]));
            }
            String code = getPersonalityType(bPercent);
            log.println(name + ": " + Arrays.toString(bPercent) + " = " + code);
        }
    }

    //method to read out the intro of the program
    public static void intro() {
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter. It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.");
        System.out.println();
    }

    //method to get the logger of the program
    //takes input scanner as a parameter to read input from the user
    //returns a new print stream to a file
    public static PrintStream getLogger(Scanner inputScanner) throws FileNotFoundException {
        System.out.print("output file name? ");
        String fileName = inputScanner.nextLine();
        return new PrintStream(new File(fileName));
    }

    //method to get input from the file
    //takes input scanner as a parameter to promt the user for the input file location
    //method returns the new file that was scanned
    public static Scanner getInputFileScanner(Scanner inputScanner) throws FileNotFoundException {
        File file = null;
        System.out.print("input file name? ");
        String inputFile = inputScanner.nextLine();
        file = new File(inputFile);
        return new Scanner(file);
    }

    //method to procoess the responses of the the file
    //passes a string of the line of the file as a parameter
    //method takes the line and puts the whole line to upper case
    //method returns the percentage of B as a int []
    //modulo is used to check what branch each character falls in
    public static int[] processResponses(String line, char letter) {
        line = line.toUpperCase();
        int[] response = new int[ARRAY_CONSTANT];
        for (int i = 0; i < line.length(); i++) {
            char curr = line.charAt(i);
            if (curr == letter) {
                if (i % 7 == 0) {
                    response[0]++;
                } else if (i % 7 == 1 || i % 7 == 2) {
                    response[1]++;
                } else if (i % 7 == 3 || i % 7 == 4) {
                    response[2]++;

                } else {
                    response[3]++; 
                }
            }
        }
        return response;
    }

    //method to get the peronality type as a code
    //takes a interger array of b percent 
    //returns a string of the code of the personality type
    public static String getPersonalityType(int[] bPercent) {
        String code = "";
        for (int i = 0; i < ARRAY_CONSTANT; i++) {
            if (bPercent[i] > 50) {
                code = code + B_OUTCOMES[i];
            } else if (bPercent[i] < 50) {
                code = code + A_OUTCOMES[i];
            }
            else{
                code = code + "X";
            }
        }
        return code;
    }
}



