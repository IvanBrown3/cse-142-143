public class whileMystery{
    public static void main(String [] args){
    whileMystery(2,2);
    }
        public static void whileMystery(int x, int y) {
            while (x > 0 && y > 0) {
                x = x - y;
                y--;
                if (x > y) {
                    System.out.print(x + " ");
                } else {
                    System.out.print(y + " ");
                }
            }
            
            System.out.println(y + x);
    }
}
