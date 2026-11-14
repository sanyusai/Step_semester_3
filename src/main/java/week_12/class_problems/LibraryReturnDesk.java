
import java.util.Scanner;

public class LibraryReturnDesk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Stack for returned books
        String[] pile = new String[3];
        int top = -1;

        // Circular queue for students
        String[] line = new String[3];
        int front = 0;
        int rear = -1;
        int size = 0;

        while (sc.hasNext()) {

            String command = sc.next().replace(",", "");

            if (command.equalsIgnoreCase("RETURN")) {

                String book = sc.next().replace(",", "");

                if (top == 2) {
                    System.out.println(book + " rejected: pile is full");
                } else {
                    top++;
                    pile[top] = book;
                    System.out.println(book + " placed on pile");
                }
            }

            else if (command.equalsIgnoreCase("SHELVE")) {

                if (top == -1) {
                    System.out.println("pile is empty");
                } else {
                    System.out.println("shelved " + pile[top]);
                    top--;
                }
            }

            else if (command.equalsIgnoreCase("WAIT")) {

                String student = sc.next().replace(",", "");

                if (size == 3) {
                    System.out.println(student + " rejected: line is full");
                } else {
                    rear = (rear + 1) % 3;
                    line[rear] = student;
                    size++;

                    System.out.println(student + " joined the line");
                }
            }

            else if (command.equalsIgnoreCase("SERVE")) {

                if (size == 0) {
                    System.out.println("no one waiting");
                } else {
                    System.out.println("served " + line[front]);

                    front = (front + 1) % 3;
                    size--;
                }
            }
        }

        sc.close();
    }
}


