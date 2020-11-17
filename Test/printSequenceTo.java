public class printSequenceTo{
    public static void main(String [] args){
        double n = printSequenceTo(5.5);
    }
        public static double printSequenceTo(double value) {
            double sum = 0.0;
            System.out.print("1/2");
            int n = 1;
            while (value > sum) {
                n++;
                System.out.print(" + " + n + "/" + (n + 1));
                sum += n / (n + 1.0);
            }

            System.out.println(" = " + sum);
            return n;
        }
    }
    
