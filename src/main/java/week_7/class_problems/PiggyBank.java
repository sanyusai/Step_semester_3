class PiggyBankAccount {

    private double savings;
    private final String id;

    public PiggyBankAccount(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {

        if (amount > 0) {
            savings = savings + amount;
        }
    }

    public void withdraw(double amount) {

        if (amount > savings) {
            System.out.println("Withdrawal rejected: insufficient savings");
        } else if (amount <= 0) {
            System.out.println("Withdrawal rejected: Amount must be greater than 0");
        } else {
            savings = savings - amount;
        }
    }

    public double getSavings() {
        return savings;
    }
}

public class PiggyBank {

    public static void main(String[] args) {

        PiggyBankAccount pb = new PiggyBankAccount("PB-1");

        pb.deposit(100);
        System.out.println("Savings after deposit: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings after withdrawal: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings after rejected withdrawal: "
                + pb.getSavings());
    }
}

