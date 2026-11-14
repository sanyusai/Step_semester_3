
import java.util.Scanner;

class Node {

    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class BusRouteStops {

    static Node build(String[] stops) {

        Node head = null;
        Node temp = null;

        for (int i = 0; i < stops.length; i++) {

            Node newNode = new Node(stops[i]);

            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        return head;
    }

    static void printRoute(Node head) {

        Node temp = head;
        int count = 0;
        String first = head.data;
        String last = head.data;

        while (temp != null) {

            System.out.print(temp.data + " -> ");

            last = temp.data;
            count++;

            temp = temp.next;
        }

        System.out.println("null");
        System.out.println("Stops: " + count +
                ", First: " + first +
                ", Last: " + last);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stops: ");
        int n = sc.nextInt();

        String[] stops = new String[n];

        System.out.println("Enter stop names:");

        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        Node head = build(stops);

        printRoute(head);

        sc.close();
    }
}
