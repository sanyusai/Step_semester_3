import java.util.Scanner;

public class GradeClassifier {

    static void classifyWithAttendance(int marks, int attendance) {
        boolean eligible = attendance >= 75 && marks >= 40;

        if (!eligible) {
            System.out.println("Detained");
        } else if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 75) {
            System.out.println("Grade: B");
        } else if (marks >= 60) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: D");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter marks: ");
        int marks = scanner.nextInt();

        System.out.print("Enter attendance percentage: ");
        int attendance = scanner.nextInt();

        classifyWithAttendance(marks, attendance);

        scanner.close();
    }
}
