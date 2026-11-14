
import java.util.Scanner;

class LinkedStack {

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            next = null;
        }
    }

    Node top = null;
    int size = 0;

    void push(String plate) {

        Node newNode = new Node(plate);

        newNode.next = top;
        top = newNode;
        size++;

        System.out.println("push " + plate +
                           " -> top " + top.data +
                           ", size " + size);
    }

    String pop() {

        if (isEmpty()) {
            return null;
        }

        String plate = top.data;
        top = top.next;
        size--;

        return plate;
    }

    String peek() {

        if (isEmpty()) {
            return null;
        }

        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class PlateStackOnAChain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedStack stack = new LinkedStack();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String command = sc.next().replace(",", "");

            if (command.startsWith("push(")) {

                String plate = command.substring(
                    5, command.length() - 1
                );

                stack.push(plate);
            }

            else if (command.equals("pop()")) {

                String plate = stack.pop();

                if (plate == null) {
                    System.out.println("pop -> stack is empty");
                } else {
                    System.out.println("pop -> " + plate +
                                       ", size " + stack.size);
                }
            }

            else if (command.equals("peek()")) {

                String plate = stack.peek();

                if (plate == null) {
                    System.out.println("peek -> stack is empty");
                } else {
                    System.out.println("peek -> " + plate);
                }
            }

            else if (command.equals("isEmpty()")) {

                System.out.println("isEmpty -> " + stack.isEmpty());
            }
        }

        sc.close();
    }
}


