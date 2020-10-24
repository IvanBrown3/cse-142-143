public class DollarFigure{
    public static final int SIZE = 7;
    
public static void main(String[] args) {
    design();
}

public static void design() {
    int stars = 0;
    int dollars = SIZE;
    
    for(int line = SIZE; line > 0; line--) {
            
        for(int i = 0; i < stars ; i++) {
            
            System.out.print("*");
        }
           for(int j = 0; j < dollars; j++) {
              
               System.out.print("$");
           
           }
        for(int k = 0; k < dollars*2 ; k++) {
            
            System.out.print("*");
        }
        
        for(int l = 0; l < dollars; l++) {
             
             System.out.print("$");
        }
        for(int m = 0; m < stars; m++) {
            System.out.print("*");
        }
        stars += 2;
        dollars -= 1;
        System.out.println();
        }
    }
}	




// $$$$$$$**************$$$$$$$
// **$$$$$$************$$$$$$**
// ****$$$$$**********$$$$$****
// ******$$$$********$$$$******
// ********$$$******$$$********
// **********$$****$$**********
// ************$**$************






    //leading stars
    //left dollars
    //double middle stars
    //right dollars
    //trailing stars
    //leading and trailing stars increase by 2


    //leading stars
    //left dollars
    //double middle stars
    //right dollars
    //trailing stars
    //leading and trailing stars increase by 2

    //leading stars
    //left dollars
    //double middle stars
    //right dollars
    //trailing stars
    //leading and trailing stars increase by 2