
import java.util.Scanner;

public class WeeklyRainfallAnalysis {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] rainfall = new double[7];

        double total = 0;
        int wettestDay = 0;
        int dryDays = 0;

        // Read rainfall for seven days
        for (int i = 0; i < 7; i++) {
            rainfall[i] = sc.nextDouble();
        }

        // Calculate total, wettest day and dry days
        for (int i = 0; i < 7; i++) {

            total = total + rainfall[i];

            if (rainfall[i] > rainfall[wettestDay]) {
                wettestDay = i;
            }

            if (rainfall[i] == 0) {
                dryDays++;
            }
        }

        double average = total / 7.0;

        System.out.print("Rainfall (mm): ");

        for (int i = 0; i < 7; i++) {
            System.out.print(rainfall[i] + " ");
        }

        System.out.println("\n");
        System.out.println("Total Rainfall: " + total + " mm");
        System.out.printf("Average Rainfall: %.2f mm%n", average);

        System.out.println(
            "Wettest Day: Day " + (wettestDay + 1) +
            " (" + rainfall[wettestDay] + " mm)"
        );

        System.out.println("Total Dry Days: " + dryDays);

        sc.close();
    }
}


