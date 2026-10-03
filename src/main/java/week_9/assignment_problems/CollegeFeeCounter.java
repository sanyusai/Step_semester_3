import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateFee();

    public String getName() {
        return name;
    }
}

class DayScholar extends Student implements BusUser {
    private static final double TRANSPORT_FEE = 12000;

    public DayScholar(String name) {
        super(name);
    }

    public double calculateFee() {
        return 40000 + getTransportFee();
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    public double calculateFee() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends Student implements BusUser {
    private static final double TRANSPORT_FEE = 12000;

    public ScholarshipStudent(String name) {
        super(name);
    }

    public double calculateFee() {
        return 20000 + getTransportFee();
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            if (type.equals("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                students[i] = new Hosteller(name);
            } else {
                students[i] = new ScholarshipStudent(name);
            }
        }

        double totalCollected = 0;

        for (Student student : students) {
            double fee = student.calculateFee();

            System.out.printf("%s: %.2f%n",
                    student.getName(), fee);

            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n",
                totalCollected);

        scanner.close();
    }
}

