import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {

    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowingDays();

    public String getDueDate() {

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        return currentDate
                .plusDays(getBorrowingDays())
                .toString();
    }

    public String getTitle() {
        return title;
    }

    public abstract String getType();
}

class BookItem extends LibraryItem {

    public BookItem(String title) {
        super(title);
    }

    public int getBorrowingDays() {
        return 14;
    }

    public String getType() {
        return "BOOK";
    }
}

class DVDItem extends LibraryItem {

    public DVDItem(String title) {
        super(title);
    }

    public int getBorrowingDays() {
        return 7;
    }

    public String getType() {
        return "DVD";
    }
}

class MagazineItem extends LibraryItem {

    public MagazineItem(String title) {
        super(title);
    }

    public int getBorrowingDays() {
        return 3;
    }

    public String getType() {
        return "MAGAZINE";
    }
}

public class LibraryItemDueDateCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        LibraryItem[] items = new LibraryItem[n];

        scanner.nextLine();

        for (int i = 0; i < n; i++) {

            String line = scanner.nextLine();

            int space = line.indexOf(" ");

            String type = line.substring(0, space);
            String title = line.substring(space + 1);

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            if (type.equals("BOOK")) {
                items[i] = new BookItem(title);
            } else if (type.equals("DVD")) {
                items[i] = new DVDItem(title);
            } else {
                items[i] = new MagazineItem(title);
            }
        }

        for (LibraryItem item : items) {

            System.out.println(item.getTitle()
                    + ": " + item.getDueDate());
        }

        scanner.close();
    }
}

