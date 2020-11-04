import java.util.*; 

public class randomStar {
    public static void main(String[] args) {
        Random r = new Random(2063064142); // ignore the 2063064142
        randomStar1(r, 12);
        
        System.out.println();
        randomStar1(r, 19);
    }
    
    public static void randomStar1(Random r, int num) {
        int randomNumber = r.nextInt(15) + 5;
        while (randomNumber != num){
            for (int i = 0; i < randomNumber; i++){
                System.out.print("*");
            }
            randomNumber = r.nextInt(15) + 5;
            System.out.println();

        }
     }
}
