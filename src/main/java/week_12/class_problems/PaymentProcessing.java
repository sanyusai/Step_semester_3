
import java.util.Scanner;

interface PaymentMode {

    double processPayment(double amount);
}

class CashPayment implements PaymentMode {

    public double processPayment(double amount) {
        return amount;
    }
}

class CardPayment implements PaymentMode {

    public double processPayment(double amount) {
        return amount + (amount * 0.02);
    }
}

class UpiPayment implements PaymentMode {

    public double processPayment(double amount) {
        return amount;
    }
}

public class PaymentProcessing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PaymentMode[] payments = new PaymentMode[n];
        String[] modes = new String[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {

            modes[i] = sc.next();
            amounts[i] = sc.nextDouble();

            if (modes[i].equalsIgnoreCase("Cash")) {
                payments[i] = new CashPayment();
            } else if (modes[i].equalsIgnoreCase("Card")) {
                payments[i] = new CardPayment();
            } else {
                payments[i] = new UpiPayment();
            }
        }

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {

            double processed = payments[i].processPayment(amounts[i]);
            double fee = processed - amounts[i];

            System.out.println(
                modes[i] + ": amount " + amounts[i] +
                ", fee " + fee +
                ", processed " + processed
            );

            grandTotal += processed;
        }

        System.out.println("Total Amount Processed: " + grandTotal);

        sc.close();
    }
}


