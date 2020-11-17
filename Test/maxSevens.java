import java.util.*;
public class maxSevens {
    public static void main(String[] args) {
        Random rand = new Random();
        maxSevens(rand, 10);
        maxSevens(rand, 10);
        maxSevens(rand, 5);
        maxSevens(rand, 8);
        maxSevens(rand, 8);
        maxSevens(rand, 3);
    }

    public static void maxSevens(Random r,int n){
        int tries = 0;
        int run = 0;
        for (int i = 0; i < n; i++){
            int randomNumber = r.nextInt(11) + 2;
            System.out.print(randomNumber  + " ");
            if (randomNumber == 7) {
                run++; 
                tries = Math.max(run, tries);
            }
        }
        System.out.println();
        System.out.println("Run of " + tries + " sevens in " + n + " tries.");
    }     
}

