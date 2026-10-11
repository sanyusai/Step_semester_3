
import java.util.Scanner;

public class ExamScoreBandCounter {

    static int firstPosition(int[] scores, int target, boolean strict) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (strict ? scores[mid] > target : scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static int countInBand(int[] scores, int low, int high) {
        int start = firstPosition(scores, low, false);
        int end = firstPosition(scores, high, true);

        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter scores in ascending order:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.print("Enter low and high: ");
        int low = sc.nextInt();
        int high = sc.nextInt();

        System.out.println("Count: " + countInBand(scores, low, high));

        sc.close();
    }
}


