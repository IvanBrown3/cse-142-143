public class CollapaseChars {
    public static void main(String [] args){
        
    
        collapseChars("bookkeeper");
        collapseChars("beeeeeeeees");
        collapseChars("aaaaaa");
        collapseChars("Mississippi");
        collapseChars("abcdef");
        collapseChars("BooOooOoo!");
        collapseChars("");


    
        
    }
    public static void collapseChars (String input){
  
        if (input.length() > 0) {
        char prev = input.charAt(0);
        int i = 0;
        while (i < input.length())
        {
            char current = input.charAt(i++);
            
            if (prev != current)
            {
                System.out.print (prev);
                prev = current;
            }

        }
        System.out.print (prev);
        System.out.println();
        }
    }
}
