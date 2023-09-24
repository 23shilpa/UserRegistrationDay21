class InvalidPasswordException1 extends Exception {
    public InvalidPasswordException1(String message) {
        super(message);
    }
}

public class Main5 {
    public static void main(String[] args) {
        try {
            String password = enterPassword();
            validatePassword(password);
            System.out.println("Valid password: " + password);
        } catch (InvalidPasswordException1 e) {
            System.out.println("Invalid password: " + e.getMessage());
        }
    }

    public static String enterPassword() {
        // You can use any method to get user input. Here, I'm using a simple example.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter your password: ");
        return scanner.nextLine();
    }

    public static void validatePassword(String password) throws InvalidPasswordException1 {
        // Rule 1: Minimum 8 characters
        if (password.length() < 8) {
            throw new InvalidPasswordException1("Password must be at least 8 characters long.");
        }

        // Rule 2: Should have at least 1 uppercase character
        boolean hasUpperCase = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
                break;
            }
        }

        if (!hasUpperCase) {
            throw new InvalidPasswordException1("Password must contain at least 1 uppercase character.");
        }

        // Additional password rules can be added here.
    }
}