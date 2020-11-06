//Ivan Brown
//11/6/20
//TA: CC Sent
//This program will create a budgeting receipt. The user will
//input a number that is the amount of expenses are income they are receiving/spending.
//These values are stored and kept for the final report summary that gives the total income 
//total expense and gives you a brief message to inform the user what type of spending habits they have.

import java.util.*;
public class BugdeterMe {
    public static final int DAYS_IN_MONTH = 31;
    public static final int MONTHLY = 1;
    public static final int DAILY = 2;
    public static final String INCOME = "income";
    public static final String EXPENSE = "expense";
    //main method creates scanner for user to input value
    //main counts the category amounts and stores it in an integer
    //the total income is also stored in main as a double that calls to the get amounts method
    //prints total income and expense statistics in the report table
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

    //displays the intro line of the code
    public static void displayIntro(){
        System.out.println("This program asks for your monthly income and");
        System.out.println("expenses, then tells you your net monthly income.");
        System.out.println();
    }

    //method to get the count of the categories
    //passes string parameter to disginguish between income and expenses
    //passes scanner object for user to enter value
    //method gets the category count and returns an integer
    public static int getCategoryCount(String categoryType,Scanner console){
        System.out.print("How many categories of " + categoryType + "? ");
        return console.nextInt();

    }

    //method to get the amounts of expenses or income
    //method stores get amounts as a double value
    //passes the int category count
    //passes method to distinguish monthly or daily
    //passes scanner object to promt user to input value
    //passes string that gives category type of either income or expenses
    //returns the total amounts for income or expenses
    public static double getAmounts(int categoryCount, int monthlyOrDaily, Scanner console, String categoryType){
        double total = 0;
        for (int i = 0; i < categoryCount; i++){
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

    //integer method to allow user to chose between monthly or daily
    //passes scanner object to input value
    //user inputs 1 for monthly 2 for daily
    public static int getMonthlyOrDaily(Scanner console){
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        return console.nextInt();

    }
    
    //method to print the total amounts rounded to two decimal places
    //passes the total as a double and string category type to distinguish expenses or income
    //method takes the average with is the total divided by days in month
    public static void printTotal(double total, String categoryType){
        double avg  = total / DAYS_IN_MONTH;
        System.out.println("Total " + categoryType + " = $" + roundUp(total) + 
                           " ($" + roundUp(avg) + "/day)");
    }

    //method to round up any value to a double and to 2 decimal places
    public static double roundUp(double value){
        return Math.round(value * 100.0) / 100.0;
    }

    //prints the report summary as static method
    //method gives the report summary and passes the total income and total expenses as parameters
    //total income/ expense passed through as paramters 
    //else statements to signify if you spend more than you earn
    //personal text comes with each type of spender or saver that you are
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


   
   



    

   

    

    