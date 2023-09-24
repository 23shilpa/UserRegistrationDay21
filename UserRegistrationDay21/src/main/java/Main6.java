class InvalidPasswordException2 extends Exception {
    public InvalidPasswordException2(String message) {
        super(message);
    }
}

public class Main6 {
    public static void main(String[] args) {
        try {
            String password = enterPassword();
            validatePassword(password);
            System.out.println("Valid password: " + password);
        } catch (InvalidPasswordException2 e) {
            System.out.println("Invalid password: " + e.getMessage());
        }
    }

    public static String enterPassword() {
        // You can use any method to get user input. Here, I'm using a simple example.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter your password: ");
        return scanner.nextLine();
    }

    public static void validatePassword(String password) throws InvalidPasswordException2 {
        // Rule 1: Minimum 8 characters
        if (password.length() < 8) {
            throw new InvalidPasswordException2("Password must be at least 8 characters long.");
        }

        // Rule 2: Should have at least 1 uppercase character
        boolean hasUpperCase = false;
        // Rule 3: Should have at least 1 numeric character
        boolean hasNumeric = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasNumeric = true;
            }

            if (hasUpperCase && hasNumeric) {
                // All rules are satisfied, no need to continue checking
                return;
            }
        }

        // Check if Rule 2 (at least 1 uppercase) is not met
        if (!hasUpperCase) {
            throw new InvalidPasswordException2("Password must contain at least 1 uppercase character.");
        }

        // Check if Rule 3 (at least 1 numeric) is not met
        if (!hasNumeric) {
            throw new InvalidPasswordException2("Password must contain at least 1 numeric character.");
        }

        // Additional password rules can be added here.
    }
}



