import java.time.LocalDate;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }

    public String getName() {
        return name;
    }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        SubscriptionPlan[] plans = new SubscriptionPlan[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            LocalDate startDate = LocalDate.parse(scanner.next());

            if (type.equals("BASIC")) {
                plans[i] = new BasicPlan(name, startDate);
            } else if (type.equals("STANDARD")) {
                plans[i] = new StandardPlan(name, startDate);
            } else {
                plans[i] = new PremiumPlan(name, startDate);
            }
        }

        for (SubscriptionPlan plan : plans) {
            LocalDate renewalDate = plan.calculateRenewalDate();

            System.out.println(plan.getName() + ": " + renewalDate);
        }

        scanner.close();
    }
}

