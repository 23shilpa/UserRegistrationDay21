class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class Main4 {
    public static void main(String[] args) {
        try {
            String password = enterPassword();
            validatePassword(password);
            System.out.println("Valid password: " + password);
        } catch (InvalidPasswordException e) {
            System.out.println("Invalid password: " + e.getMessage());
        }
    }

    public static String enterPassword() {
        // You can use any method to get user input. Here, I'm using a simple example.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter your password: ");
        return scanner.nextLine();
    }

    public static void validatePassword(String password) throws InvalidPasswordException {
        // Rule 1: Minimum 8 characters
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters long.");
        }

        // Additional password rules can be added here.
    }
}