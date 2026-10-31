import java.util.HashSet;
import java.util.Scanner;

public class TransactionDuplicateCheck {

    static boolean hasDuplicate(String[] transactionIds) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < transactionIds.length; i++) {
            if (set.contains(transactionIds[i])) {
                return true;
            }

            set.add(transactionIds[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        String[] transactionIds = new String[n];

        System.out.println("Enter transaction IDs:");

        for (int i = 0; i < n; i++) {
            transactionIds[i] = sc.next();
        }

        boolean result = hasDuplicate(transactionIds);

        System.out.println("Has duplicate: " + result);

        sc.close();
    }
}

