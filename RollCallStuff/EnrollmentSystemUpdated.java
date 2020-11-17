import java.util.*;
import java.io.*;

public class EnrollmentSystemUpdated {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        PrintStream output = new PrintStream(new File("NewTA142.txt"));
        int choice = -1;
        while (choice != 0) {
            System.out.print("Would you like to rollCall (1), enrollClass (2), or quit (0)? ");
            choice = console.nextInt();
            if (choice == 1) {
                System.out.print("What class would you like to roll call? ");
                String courseName = console.next();
                Scanner input = new Scanner(new File(courseName + ".txt"));
                while(input.hasNextLine()) {
                    String line = input.nextLine();
                    rollCall(line, courseName);
                }

            
            } else if (choice == 2) {
                System.out.print("What class would you like to enroll? ");
                String courseName = console.next();
                enrollClass(console, courseName + ".txt", output);
            }
        }
        
    }

    public static void rollCall(String line, String courseName) {
        Scanner tokens = new Scanner(line);
        String lastName = tokens.next();
        String firstName = tokens.next();
        int age = tokens.nextInt();
        int id = tokens.nextInt();

        if (age >= 18){
            System.out.println("    " + firstName + " " + lastName);
        }
    }   

    public static void enrollClass(Scanner console, String fileName, PrintStream output) throws FileNotFoundException {
        System.out.print("How many students would you like to enroll in this class? ");
        int kids = console.nextInt();
        console.nextLine();
        for(int i = 1; i < kids + 1; i++){
            System.out.print("Student " + i + " first name: ");
            String firstName = console.nextLine(); 
            
            System.out.print("Student " + i + " last name: ");
            String lastName = console.nextLine();
            
            System.out.print("Student " + i + " age: ");
            int age = console.nextInt();
            
            System.out.print("Student " + i + " id: ");
            int id = console.nextInt();
            console.nextLine();
            System.out.println();
            output.println(lastName + " " + firstName + " " + age + " " + id); 
        }

    }
}
