import java.util.Scanner;

abstract class Ticket {
    protected int count;
    private static final double CONVENIENCE_FEE = 20;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double getPrice();

    public double calculateAmount() {
        return (getPrice() * count) + (CONVENIENCE_FEE * count);
    }

    public abstract String getSeatType();
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) {
        super(count);
    }

    public double getPrice() {
        return 150;
    }

    public String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) {
        super(count);
    }

    public double getPrice() {
        return 250;
    }

    public String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) {
        super(count);
    }

    public double getPrice() {
        return 400;
    }

    public String getSeatType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {
            String seat = scanner.next();
            int count = scanner.nextInt();

            if (seat.equals("REGULAR")) {
                tickets[i] = new RegularTicket(count);
            } else if (seat.equals("PREMIUM")) {
                tickets[i] = new PremiumTicket(count);
            } else {
                tickets[i] = new ReclinerTicket(count);
            }
        }

        double total = 0;

        for (Ticket ticket : tickets) {
            double amount = ticket.calculateAmount();

            System.out.printf("%s: %.2f%n",
                    ticket.getSeatType(), amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}

