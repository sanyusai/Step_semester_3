
import java.util.Scanner;

class Node {

    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class CancelABooking {

    static Node removeFirst(Node head, String booking) {

        if (head == null) {
            System.out.println(booking + " not found");
            return head;
        }

        if (head.data.equals(booking)) {
            return head.next;
        }

        Node temp = head;

        while (temp.next != null) {

            if (temp.next.data.equals(booking)) {
                temp.next = temp.next.next;
                return head;
            }

            temp = temp.next;
        }

        System.out.println(booking + " not found");
        return head;
    }

    static void display(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node head = null;
        Node temp = null;

        System.out.print("Enter number of bookings: ");
        int n = sc.nextInt();

        System.out.println("Enter booking numbers:");

        for (int i = 0; i < n; i++) {

            String booking = sc.next();

            Node newNode = new Node(booking);

            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        System.out.print("Enter booking to cancel: ");
        String booking = sc.next();

        head = removeFirst(head, booking);

        display(head);

        sc.close();
    }
}
