
import java.util.Scanner;

public class ClassAttendanceTracker {

    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int streak = 0;
        int longest = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                streak++;

                if (streak > longest) {
                    longest = streak;
                }
            } else {
                streak = 0;
            }
        }

        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] days = new int[n];

        System.out.println("Enter attendance (1 for present, 0 for absent):");
        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }

        int[] result = attendanceSummary(days);

        System.out.println("Present: " + result[0]
                + ", Longest streak: " + result[1]);

        sc.close();
    }
}
