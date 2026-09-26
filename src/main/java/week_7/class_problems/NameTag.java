class NameTagDetails {

    private final String firstName;
    private final String lastName;

    public NameTagDetails(String fullName) {

        String[] parts = fullName.split(" ");

        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getNickname() {

        return firstName + " " + lastName.charAt(0) + ".";
    }
}

public class NameTag {

    public static void main(String[] args) {

        NameTagDetails tag = new NameTagDetails("Maria Gomez");

        System.out.println("Nickname: " + tag.getNickname());
    }
}

