import java.util.Scanner;

abstract class TravelBooking {
    protected double distance;
    private static final double BOOKING_FEE = 50;

    public TravelBooking(double distance) {
        this.distance = distance;
    }

    public abstract double calculateBaseFare();

    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    public abstract String getMode();
}

class BusBooking extends TravelBooking {
    public BusBooking(double distance) {
        super(distance);
    }

    public double calculateBaseFare() {
        return 2 * distance;
    }

    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distance) {
        super(distance);
    }

    public double calculateBaseFare() {
        return 1.5 * distance;
    }

    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distance) {
        super(distance);
    }

    public double calculateBaseFare() {
        return 2500 + (4 * distance);
    }

    public String getMode() {
        return "FLIGHT";
    }
}

public class TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();

            if (mode.equals("BUS")) {
                bookings[i] = new BusBooking(distance);
            } else if (mode.equals("TRAIN")) {
                bookings[i] = new TrainBooking(distance);
            } else {
                bookings[i] = new FlightBooking(distance);
            }
        }

        for (TravelBooking booking : bookings) {
            double total = booking.calculateTotal();

            System.out.printf("%s: %.2f%n",
                    booking.getMode(), total);
        }

        scanner.close();
    }
}

