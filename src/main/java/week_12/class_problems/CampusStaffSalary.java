
import java.util.Scanner;

class Staff {

    String name;
    double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0;
    }

    String getType() {
        return "Staff";
    }

    double getTotal() {
        return baseSalary + getBonus();
    }
}

class Teacher extends Staff {

    Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    double getBonus() {
        return 5000;
    }

    String getType() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {

    LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    double getBonus() {
        return 2000;
    }

    String getType() {
        return "LabAssistant";
    }
}

public class CampusStaffSalary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("Teacher")) {
                staff[i] = new Teacher(name, salary);
            } else if (type.equals("LabAssistant")) {
                staff[i] = new LabAssistant(name, salary);
            } else {
                staff[i] = new Staff(name, salary);
            }
        }

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {

            double bonus = staff[i].getBonus();
            double total = staff[i].getTotal();

            System.out.println(
                staff[i].name + " (" + staff[i].getType() +
                "): base " + staff[i].baseSalary +
                ", bonus " + bonus +
                ", total " + total
            );

            grandTotal += total;
        }

        System.out.println("Grand Total Salary: " + grandTotal);

        sc.close();
    }
}


