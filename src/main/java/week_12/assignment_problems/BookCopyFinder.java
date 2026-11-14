
import java.util.Scanner;

class Node {

    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

public class BookCopyFinder {

    static String find(Node head, String id) {

        Node temp = head;

        int position = 1;
        int firstPosition = -1;
        int copies = 0;

        while (temp != null) {

            if (temp.data.equals(id)) {

                if (firstPosition == -1) {
                    firstPosition = position;
                }

                copies++;
            }

            temp = temp.next;
            position++;
        }

        if (copies == 0) {
            return id + " not found";
        }

        return id + " first at position " +
                firstPosition + ", copies: " + copies;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        Node head = null;
        Node temp = null;

        System.out.println("Enter book IDs:");

        for (int i = 0; i < n; i++) {

            String id = sc.next();

            Node newNode = new Node(id);

            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        System.out.print("Enter ID to find: ");
        String searchId = sc.next();

        System.out.println(find(head, searchId));

        sc.close();
    }
}
