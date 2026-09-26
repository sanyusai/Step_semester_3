import java.util.Scanner;

abstract class Delivery {

    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();

    public abstract String getType();
}

class StandardDelivery extends Delivery {

    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    public double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }

    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {

    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    public double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }

    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {

    private double customsFee;

    public InternationalDelivery(double weight,
                                  double distance,
                                  double customsFee) {

        super(weight, distance);
        this.customsFee = customsFee;
    }

    public double calculateFee() {
        return 25
                + (2.00 * weight)
                + (0.50 * distance)
                + customsFee;
    }

    public String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFeeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Delivery[] deliveries = new Delivery[n];

        for (int i = 0; i < n; i++) {

            String type = scanner.next();

            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();

            if (type.equals("STANDARD")) {

                deliveries[i] =
                        new StandardDelivery(weight, distance);

            } else if (type.equals("EXPRESS")) {

                deliveries[i] =
                        new ExpressDelivery(weight, distance);

            } else {

                double customsFee = scanner.nextDouble();

                deliveries[i] =
                        new InternationalDelivery(
                                weight, distance, customsFee);
            }
        }

        double total = 0;

        for (Delivery delivery : deliveries) {

            double fee = delivery.calculateFee();

            System.out.printf("%s: %.2f%n",
                    delivery.getType(), fee);

            total = total + fee;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}

