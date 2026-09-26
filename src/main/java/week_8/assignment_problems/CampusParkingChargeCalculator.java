import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();

    public abstract String getType();
}

class BikeVehicle extends Vehicle {
    public BikeVehicle(int hours) {
        super(hours);
    }

    public double calculateCharge() {
        return hours * 10;
    }

    public String getType() {
        return "BIKE";
    }
}

class CarVehicle extends Vehicle {
    public CarVehicle(int hours) {
        super(hours);
    }

    public double calculateCharge() {
        if (hours == 1) {
            return 30;
        }

        return 30 + (hours - 1) * 20;
    }

    public String getType() {
        return "CAR";
    }
}

class TruckVehicle extends Vehicle {
    public TruckVehicle(int hours) {
        super(hours);
    }

    public double calculateCharge() {
        double charge = hours * 50;

        if (charge < 100) {
            charge = 100;
        }

        return charge;
    }

    public String getType() {
        return "TRUCK";
    }
}

public class CampusParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();

            if (type.equals("BIKE")) {
                vehicles[i] = new BikeVehicle(hours);
            } else if (type.equals("CAR")) {
                vehicles[i] = new CarVehicle(hours);
            } else {
                vehicles[i] = new TruckVehicle(hours);
            }
        }

        double total = 0;

        for (Vehicle vehicle : vehicles) {
            double charge = vehicle.calculateCharge();

            System.out.printf("%s: %.2f%n",
                    vehicle.getType(), charge);

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}

