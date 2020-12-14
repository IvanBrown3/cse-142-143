import java.util.*;
import java.io.*;
public class CountCoins {
    public static void main(String[] args) throws FileNotFoundException {
    
        Scanner input1 = new Scanner(new File("input1.txt"));
        countCoins(input1);

        Scanner input2 = new Scanner(new File("input2.txt"));
        countCoins(input2);

    }

   public static void countCoins(Scanner console){
        double pennyTotal = 0;
        double nickelTotal = 0;
        double quarterTotal = 0;
        double dimeTotal = 0;
        double fullTotal = 0;
        while(console.hasNext()){
            int num = console.nextInt();
            String type = console.next();
            if(type.toLowerCase() == "pennies"){
                pennyTotal = num; 
            }
            else if(type.toLowerCase() == "nickels"){
                nickelTotal = num * 5;
            }
            else if(type.toLowerCase() == "quarters"){
                quarterTotal = num * 25;
            }
            else if(type.toLowerCase() == "dimes"){
                dimeTotal = num * 10;
            }
            fullTotal = (dimeTotal + nickelTotal + pennyTotal + quarterTotal) / 100;
        }
		System.out.println("Total money: $" + Double.toString(fullTotal));
   }
}

