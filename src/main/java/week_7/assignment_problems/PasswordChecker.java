class PasswordData {

    private final String password;

    public PasswordData(String password) {
        this.password = password;
    }

    public String getStrength() {

        int length = password.length();

        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}

public class PasswordChecker {

    public static void main(String[] args) {

        PasswordData pc = new PasswordData("abcd");

        PasswordData pc2 = new PasswordData("abcdefghij");

        System.out.println("Password 1 strength: "
                + pc.getStrength());

        System.out.println("Password 2 strength: "
                + pc2.getStrength());
    }
}

