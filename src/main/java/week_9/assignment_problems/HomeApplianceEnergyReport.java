import java.util.Scanner;

interface SaverMode {
    double applySaverMode(double units);
}

abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPower();

    public abstract String getType();

    public double calculateUnits() {
        return (getPower() * hours) / 1000;
    }

    public double calculateCost() {
        return calculateUnits() * 8;
    }
}

class FridgeAppliance extends Appliance {
    public FridgeAppliance(double hours) {
        super(hours);
    }

    public double getPower() {
        return 150;
    }

    public String getType() {
        return "FRIDGE";
    }
}

class ACAppliance extends Appliance implements SaverMode {
    public ACAppliance(double hours) {
        super(hours);
    }

    public double getPower() {
        return 1500;
    }

    public String getType() {
        return "AC";
    }

    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

class TVAppliance extends Appliance {
    public TVAppliance(double hours) {
        super(hours);
    }

    public double getPower() {
        return 100;
    }

    public String getType() {
        return "TV";
    }
}

class WasherAppliance extends Appliance implements SaverMode {
    public WasherAppliance(double hours) {
        super(hours);
    }

    public double getPower() {
        return 500;
    }

    public String getType() {
        return "WASHER";
    }

    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Appliance[] appliances = new Appliance[n];
        boolean[] saverRequested = new boolean[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double hours = scanner.nextDouble();

            if (scanner.hasNext("SAVER")) {
                scanner.next();
                saverRequested[i] = true;
            }

            if (type.equals("FRIDGE")) {
                appliances[i] = new FridgeAppliance(hours);
            } else if (type.equals("AC")) {
                appliances[i] = new ACAppliance(hours);
            } else if (type.equals("TV")) {
                appliances[i] = new TVAppliance(hours);
            } else {
                appliances[i] = new WasherAppliance(hours);
            }
        }

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            Appliance appliance = appliances[i];

            if (saverRequested[i]
                    && !(appliance instanceof SaverMode)) {

                System.out.println(
                        appliance.getType()
                        + ": saver mode not supported");

                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested[i]) {
                SaverMode saver = (SaverMode) appliance;
                units = saver.applySaverMode(units);
            }

            double cost = units * 8;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    appliance.getType(), units, cost);

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        scanner.close();
    }
}

