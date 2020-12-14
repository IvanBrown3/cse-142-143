import java.util.*;
import java.io.*;

public class TargetedHiring {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("hiring_info.txt"));
        PrintStream output = new PrintStream(new File("hiring_output.txt"));
        int[] counts = determineMajor(input);
        reportStatistics(counts, output); 
        System.out.print(Arrays.toString(counts));       
    }

    public static int[] determineMajor(Scanner input)  {
        int [] counts = new int[4];
        String line = input.nextLine();
            Scanner scanLine = new Scanner(line);
            while(scanLine.hasNext()){
                String standing = scanLine.next();
                String major = scanLine.next();
                if(standing.equals("Freshman") && major.equals("CS")){
                    counts[0]++;
                }
                else if(standing.equals("Sophomore") && major.equals("CS")){
                    counts[1]++;
                }
                else if(standing.equals("Junior") && major.equals("CS")){
                    counts[2]++;
                }
                else if(standing.equals("Senior") && major.equals("CS")){
                    counts[3]++;
                }
        }
        return counts;
    }

    

    public static void reportStatistics(int[] counts, PrintStream output) {
        String standing = "";
        if(counts[3] > counts[2] && counts[3] > counts[1] && counts[3] > counts[0]){
            standing = "Senior";
        }
        else if(counts[2] > counts[3] && counts[2] > counts[1] && counts[2] > counts[0]){
            standing = "Junior";
        }
        else if(counts[1] > counts[3] && counts[1] > counts[2] && counts[1] > counts[0]){
            standing = "Sophomore";
        }
        else{
            standing = "Freshman";
        }
        output.println("Freshman class has " + counts[0] + " CS Majors");
        output.println("Sophomore class has " + counts[1] + " CS Majors");
        output.println("Junior class has " + counts[2] + " CS Majors");
        output.println("Senior class has " + counts[3] + " CS Majors");
        output.println("Suggested Hire: " + standing + " class");
    }
}