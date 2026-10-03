import java.util.Scanner;

interface NightService {
    double applyNightFare(double fare);
}

abstract class Cab {
    protected double distance;

    public Cab(double distance) {
        this.distance = distance;
    }

    public abstract double getRate();

    public abstract String getType();

    public double calculateFare() {
        double fare = distance * getRate();

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double distance) {
        super(distance);
    }

    public double getRate() {
        return 10;
    }

    public String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double distance) {
        super(distance);
    }

    public double getRate() {
        return 14;
    }

    public String getType() {
        return "SEDAN";
    }

    public double applyNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUVCab extends Cab implements NightService {
    public SUVCab(double distance) {
        super(distance);
    }

    public double getRate() {
        return 18;
    }

    public String getType() {
        return "SUV";
    }

    public double applyNightFare(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Cab[] cabs = new Cab[n];
        String[] times = new String[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            String time = scanner.next();

            times[i] = time;

            if (type.equals("MINI")) {
                cabs[i] = new MiniCab(distance);
            } else if (type.equals("SEDAN")) {
                cabs[i] = new SedanCab(distance);
            } else {
                cabs[i] = new SUVCab(distance);
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            Cab cab = cabs[i];

            if (times[i].equals("NIGHT")
                    && !(cab instanceof NightService)) {

                System.out.println(
                        cab.getType() + ": night service not available");

                continue;
            }

            double fare = cab.calculateFare();

            if (times[i].equals("NIGHT")) {
                NightService nightCab = (NightService) cab;
                fare = nightCab.applyNightFare(fare);
            }

            System.out.printf("%s: %.2f%n",
                    cab.getType(), fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}

