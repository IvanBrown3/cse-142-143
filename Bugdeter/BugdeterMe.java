import java.util.*;

public class BugdeterMe {
    public static final int DAYS_IN_MONTH = 31;
    public static final int MONTHLY = 1;
    public static final int DAILY = 2;
    public static final String INCOME = "income";
    public static final String EXPENSE = "expense";

    public static void main(String[] args){
    displayIntro();
    Scanner console = new Scanner(System.in);
    int incomeCategoryCount = getCategoryCount(INCOME,console);
    double totalIncome = getAmounts(incomeCategoryCount, MONTHLY, console, INCOME);
    int monthlyOrDaily = getMonthlyOrDaily(console);
    int expenseCategoryCount = getCategoryCount(EXPENSE,console);
    double totalExpense = getAmounts(expenseCategoryCount, monthlyOrDaily,console, EXPENSE);
    printTotal(totalIncome, INCOME);
    printTotal(totalExpense, "expenses");
    printReportSummary(totalIncome, totalExpense);
}
    public static void displayIntro(){
        System.out.println("This program asks for your monthly income and");
        System.out.println("expenses, then tells you your net monthly income.");
        System.out.println();
    }

    public static int getCategoryCount(String categoryType,Scanner console){
        System.out.print("How many categories of " + categoryType + "? ");
        return console.nextInt();

    }
   
    public static double getAmounts(int categoryCount, int monthlyOrDaily, Scanner console, String categoryType){
        double total = 0;
        for (int c = 0; c < categoryCount; c++){
            System.out.print("    Next " + categoryType + " amount? $" );
            double amount = console.nextDouble();
            if (monthlyOrDaily == DAILY) {
                amount = amount * DAYS_IN_MONTH;
            }
            total = total + amount;
        }
        System.out.println();
        return total;
    }

    public static int getMonthlyOrDaily(Scanner console){
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        return console.nextInt();

    }

    public static void printTotal(double total, String categoryType){
        double avg  = total / DAYS_IN_MONTH;
        System.out.println("Total " + categoryType + " = $" + roundUp(total) + 
                           " ($" + roundUp(avg) + "/day)");
    }

    public static double roundUp(double value){
        return Math.round(value * 100.0) / 100.0;
    }

    public static void printReportSummary(double totalIncome, double totalExpense) {
        System.out.println();
        double netIncome = totalIncome - totalExpense;
        if (netIncome > 0) {
            System.out.println("You earned $" + roundUp(netIncome) + 
                                " more than you spent this month.");
        } else {
            System.out.println("You spent $" + roundUp(Math.abs(netIncome)) + 
                                " more than you earned this month.");
        }
        String category = ""; 
        String message = "";
        if (netIncome > 250) {
            category = "big saver.";
            message = "Keep it up, and rack it up!";
        } else if (netIncome <= 250 && netIncome > 0) {
            category = "saver.";
            message = "Your good but that good. Try to spend less.";
        } else if (netIncome > -250 && netIncome <= 0) {
            category = "spender.";
            message = "Think before you spend all your bread.";
        } else if (netIncome <= -250) {
            category = "big spender.";
            message = "Blowing a straight bag! Respect.";
        } 
        System.out.println("You're a " + category);
        System.out.println(message);
    }
}


   
   



    

   

    

    //after this it is the return total statements 