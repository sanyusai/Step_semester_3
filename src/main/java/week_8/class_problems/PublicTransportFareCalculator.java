import java.util.Scanner;

abstract class Transport {

    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();

    public abstract String getType();
}

class BusTransport extends Transport {

    public BusTransport(double distance) {
        super(distance);
    }

    public double calculateFare() {

        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }

    public String getType() {
        return "BUS";
    }
}

class TrainTransport extends Transport {

    public TrainTransport(double distance) {
        super(distance);
    }

    public double calculateFare() {
        return 3 + (0.15 * distance);
    }

    public String getType() {
        return "TRAIN";
    }
}

class MetroTransport extends Transport {

    private double peakHourFactor;

    public MetroTransport(double distance,
                           double peakHourFactor) {

        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    public double calculateFare() {

        return (1.50 + (0.20 * distance))
                * peakHourFactor;
    }

    public String getType() {
        return "METRO";
    }
}

public class PublicTransportFareCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Transport[] transports = new Transport[n];

        for (int i = 0; i < n; i++) {

            String type = scanner.next();

            double distance = scanner.nextDouble();

            if (type.equals("BUS")) {

                transports[i] =
                        new BusTransport(distance);

            } else if (type.equals("TRAIN")) {

                transports[i] =
                        new TrainTransport(distance);

            } else {

                double peakHourFactor =
                        scanner.nextDouble();

                transports[i] =
                        new MetroTransport(
                                distance,
                                peakHourFactor);
            }
        }

        double total = 0;

        for (Transport transport : transports) {

            double fare = transport.calculateFare();

            System.out.printf("%s: %.2f%n",
                    transport.getType(), fare);

            total = total + fare;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}

