import java.util.*;

public class Budgeter {
    public static final int DAYS_IN_MONTH = 31;
    public static final int DAILY = 2;
    public static void main(String[] args) {
        displayIntroMessage();
        int incomeCategoryCount = getCategoryCount("income");
        double totalIncome = getIncomeAmounts(incomeCategoryCount);
        int monthlyOrDaily = getMonthlyOrDaily();
        int expenseCategoryCount = getCategoryCount("expense");
        double totalExpense = getExpenseAmounts(expenseCategoryCount, monthlyOrDaily);
        printTotal(totalIncome, "income");
        printTotal(totalExpense, "expense");
        printReportSummary(totalIncome, totalExpense);
    }

    public static void displayIntroMessage() {
        System.out.println(
                "This program asks for your monthly income and expense then tells you your net monthly income.");
        System.out.println();
    }

    public static int getCategoryCount(String categoryType) {
        Scanner console = new Scanner(System.in);
        System.out.print("How many categories of " + categoryType + "? ");
        return console.nextInt();
    }

    public static double getIncomeAmounts(int categoryCount) {
        double totalIncome = 0;
        Scanner console = new Scanner(System.in);
        for (int c = 0; c < categoryCount; c++) {
            System.out.print("   Next income amount? $");
            double amount = console.nextDouble();
            totalIncome = totalIncome + amount;
        }
        System.out.println();
        return totalIncome;
    }

    public static double getExpenseAmounts(int categoryCount, int monthlyOrDaily) {
        double totalExpense = 0;
        Scanner console = new Scanner(System.in);
        for (int c = 0; c < categoryCount; c++) {
            System.out.print("    Next expense amount? $");
            double amount = console.nextDouble();
            if (monthlyOrDaily == DAILY) {
                amount = amount * DAYS_IN_MONTH;
            }
            totalExpense = totalExpense + amount;

        }
        System.out.println();
        return totalExpense;
    }

    public static int getMonthlyOrDaily() {
        System.out.print("Enter 1) monthly or 2) daily expenses? ");
        Scanner console = new Scanner(System.in);
        return console.nextInt();

    }

    public static void printTotal(double total, String categoryType) {
        double avg = total / DAYS_IN_MONTH;
        System.out.println("Total " + categoryType + " = $" + roundUp(total) + " ($" + roundUp(avg) + "/day)");
    }
    public static double roundUp(double value) {
        //default to two decimal places
        return roundUp(value,2);
    }
    public static double roundUp(double value,int numDecimal) {
        double i = Math.pow(10, numDecimal);
        return Math.round(value * i) / i;
    }

    public static void printReportSummary(double totalIncome, double totalExpense) {
        System.out.println();
        double netIncome = totalIncome - totalExpense;
        if (netIncome > 0) {
            System.out.println("You earned $" + netIncome + " more than you spent this month.");
        } else {
            System.out.println("You spent $" + Math.abs(netIncome) + " more than you earned this month.");
        }

        String category = ""; // saver or spender or big saver or big spender
        if (netIncome > 250) {
            category = "big saver.";
        } else if (netIncome <= 250 && netIncome > 0) {
            category = "saver.";
        } else if (netIncome >= -250 && netIncome < 0) {
            category = "spender.";
        } else if (netIncome < -250) {
            category = "big spender.";
        } else {
            category = "budget balancer.";
        }
        System.out.print("You're a " + category);
    }
}
