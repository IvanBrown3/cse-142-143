public class IfElseMystery{
    public static void main(String [] args) {
        IfElse(4,20);
    }
        public static void IfElse(int a, int b) {
            if (a < b) {
                a = a * 2;
            }
            if (a > b) {
                a = a - 10;
            } else {
                b++;
            }
            System.out.println(a + " " + b);
        }   
}
    