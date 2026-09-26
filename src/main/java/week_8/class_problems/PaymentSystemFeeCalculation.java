import java.util.Scanner;

abstract class PaymentMethod {

    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAmount();

    public abstract String getType();
}

class CardPayment extends PaymentMethod {

    public CardPayment(double amount) {
        super(amount);
    }

    public double calculateAmount() {
        return amount + (amount * 0.02);
    }

    public String getType() {
        return "CARD";
    }
}

class WalletPayment extends PaymentMethod {

    public WalletPayment(double amount) {
        super(amount);
    }

    public double calculateAmount() {
        return amount + (amount * 0.01);
    }

    public String getType() {
        return "WALLET";
    }
}

class BankTransferPayment extends PaymentMethod {

    public BankTransferPayment(double amount) {
        super(amount);
    }

    public double calculateAmount() {
        return amount;
    }

    public String getType() {
        return "BANKTRANSFER";
    }
}

public class PaymentSystemFeeCalculation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        PaymentMethod[] payments = new PaymentMethod[n];

        for (int i = 0; i < n; i++) {

            String type = scanner.next();
            double amount = scanner.nextDouble();

            if (type.equals("CARD")) {
                payments[i] = new CardPayment(amount);
            } else if (type.equals("WALLET")) {
                payments[i] = new WalletPayment(amount);
            } else {
                payments[i] = new BankTransferPayment(amount);
            }
        }

        double total = 0;

        for (PaymentMethod payment : payments) {

            double adjustedAmount = payment.calculateAmount();

            System.out.printf("%s: %.2f%n",
                    payment.getType(), adjustedAmount);

            total = total + adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}

