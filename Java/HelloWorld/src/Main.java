import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double principal = 0.0;
        double air = 0.0;
        int years = 0;

        while(true) {
            System.out.println("Principal: ");
            principal = scanner.nextDouble();
            if (principal >= 1000 && principal <= 1000000 ) break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

        while(true) {
            System.out.println("Annual Interest Rate: ");
            air = scanner.nextDouble();
            if (air >= 1.0 && air <=30.0) break;
            System.out.println("Enter a value between 1 and 30");
        }

        while(true) {
            System.out.println("Period (Years): ");
            years = scanner.nextInt();
            if (years >=1 && years <=30) break;
            System.out.println("Enter a value between 1 and 30");
        }
        double monthlyInterest = air/ 100.0 / 12.0;
        int numberOfPayments = years*12;

        double mortgage = principal * (monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments))
                / (Math.pow(1+monthlyInterest,numberOfPayments) - 1);


        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println("Mortgage: "+ mortgageFormatted);

    }

    public static void noChecks(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Principal: ");
        double p = scanner.nextDouble();
        System.out.println("Annual Interest Rate: ");
        double air = scanner.nextDouble();
        double monthlyInterest = air/ 100.0 / 12.0;
        System.out.println("Period (Years): ");
        int years = scanner.nextInt();
        int numberOfPayments = years*12;

        double mortgage = p * (monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments))
                / (Math.pow(1+monthlyInterest,numberOfPayments) - 1);


        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println("Mortgage: "+ mortgageFormatted);

    }

}