import java.util.Arrays;
import java.util.Scanner;

public class Top3PodiumFinder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of participants: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter the scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        Arrays.sort(scores);

        System.out.println("Top 3 scores:");

        int count = 0;

        for (int i = n - 1; i >= 0 && count < 3; i--) {
            System.out.println(scores[i]);
            count++;
        }

        sc.close();
    }
}
