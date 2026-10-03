import java.util.Scanner;

abstract class ElectricityConnection {
    protected int units;

    public ElectricityConnection(int units) {
        this.units = units;
    }

    public abstract double calculateBill();

    public abstract String getType();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(int units) {
        super(units);
    }

    public double calculateBill() {
        if (units <= 100) {
            return units * 5;
        }

        return (100 * 5) + ((units - 100) * 7);
    }

    public String getType() {
        return "HOME";
    }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(int units) {
        super(units);
    }

    public double calculateBill() {
        return (units * 8) + 100;
    }

    public String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(int units) {
        super(units);
    }

    public double calculateBill() {
        double bill = units * 6;

        if (bill < 1000) {
            bill = 1000;
        }

        return bill;
    }

    public String getType() {
        return "FACTORY";
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ElectricityConnection[] connections =
                new ElectricityConnection[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();

            if (type.equals("HOME")) {
                connections[i] = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                connections[i] = new ShopConnection(units);
            } else {
                connections[i] = new FactoryConnection(units);
            }
        }

        double total = 0;

        for (ElectricityConnection connection : connections) {
            double bill = connection.calculateBill();

            System.out.printf("%s: %.2f%n",
                    connection.getType(), bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}

