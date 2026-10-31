import java.util.HashMap;
import java.util.Scanner;

public class EmployeeIDLookup {

    static HashMap<String, String> buildLookup(String[][] records) {
        HashMap<String, String> lookup = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            lookup.put(records[i][0], records[i][1]);
        }

        return lookup;
    }

    static String getDepartment(HashMap<String, String> lookup, String employeeId) {
        if (lookup.containsKey(employeeId)) {
            return lookup.get(employeeId);
        }

        return "Unknown";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] records = {
            {"E245", "Finance"},
            {"E110", "Engineering"},
            {"E390", "Marketing"},
            {"E101", "Engineering"}
        };

        HashMap<String, String> lookup = buildLookup(records);

        System.out.print("Enter employee ID: ");
        String id = sc.nextLine();

        String department = getDepartment(lookup, id);

        System.out.println("Department: " + department);

        sc.close();
    }
}

