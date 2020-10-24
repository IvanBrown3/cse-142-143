public class AsciiArt{
    //main method
    public static void main(String[] args){
       tophalf();
       bottomhalf();
    }
    //top half of figure 
    public static void tophalf() {
       for(int line = 1 ; line <= 3; line++){
          for(int i = 1; i <= 7 - line; i++){
             System.out.print("&");
          }
          
          for(int i = 1; i <= 2 * line + 1; i++){
             System.out.print("*");
          }
          
          for(int i = 1; i <= 7 - line; i++){
             System.out.print("$");
          }
          System.out.println();
       }
    }
    
    //bottom half of figure
    public static void bottomhalf() {
       for(int line = 4; line <= 6; line++){
       
          for(int i = 0; i < line; i++){         
             System.out.print("&");
          }
          for(int i = 0; i < -2 * line + 15; i++) {
             System.out.print("*");
          }   
          for(int i = 0; i < line; i++){
             System.out.print("$");
          }
          System.out.println();
       } 
    }
 }
 
 // //   
 ///   $$$$$$***$$$$$$
 // / 	$$$$$*****$$$$$
 // 	$$$$*******$$$$
 //    $$$$*******$$$$
 // 	$$$$$*****$$$$$
 // 	$$$$$$***$$$$$$
 