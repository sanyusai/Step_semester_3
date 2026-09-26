import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();

    public abstract String getType();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount * 0.90;
    }

    public String getType() {
        return "STUDENT";
    }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount * 0.95;
    }

    public String getType() {
        return "STAFF";
    }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount + 10;
    }

    public String getType() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            if (type.equals("STUDENT")) {
                customers[i] = new StudentCustomer(amount);
            } else if (type.equals("STAFF")) {
                customers[i] = new StaffCustomer(amount);
            } else {
                customers[i] = new GuestCustomer(amount);
            }
        }

        double total = 0;

        for (Customer customer : customers) {
            double finalAmount = customer.calculateFinalAmount();

            System.out.printf("%s: %.2f%n",
                    customer.getType(), finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}

