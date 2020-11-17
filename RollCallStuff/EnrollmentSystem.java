import java.util.*;
import java.io.*;

public class EnrollmentSystem {
    public static void main(String[] arg) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.print("What class would you like to roll call?");
        String courseName = console.nextLine();
        Scanner input = new Scanner(new File(courseName + ".txt"));
        System.out.println("The following students in HeadTA142 are of voting age: ");
        while (input.hasNextLine()) {
            String line = input.nextLine();
            rollCall(line, courseName);
        }
    }

    // Parses through user information to report
    // a list of student's who are 18+ years old
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
}
