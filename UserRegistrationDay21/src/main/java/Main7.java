class InvalidPasswordException3 extends Exception {
    public InvalidPasswordException3(String message) {
        super(message);
    }
}

public class Main7 {
    public static void main(String[] args) {
        try {
            String password = enterPassword();
            validatePassword(password);
            System.out.println("Valid password: " + password);
        } catch (InvalidPasswordException3 e) {
            System.out.println("Invalid password: " + e.getMessage());
        }
    }

    public static String enterPassword() {
        // You can use any method to get user input. Here, I'm using a simple example.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter your password: ");
        return scanner.nextLine();
    }

    public static void validatePassword(String password) throws InvalidPasswordException3 {
        // Rule 1: Minimum 8 characters
        if (password.length() < 8) {
            throw new InvalidPasswordException3("Password must be at least 8 characters long.");
        }

        // Rule 2: Should have at least 1 uppercase character
        boolean hasUpperCase = false;
        // Rule 3: Should have at least 1 numeric character
        boolean hasNumeric = false;
        // Rule 4: Should have exactly 1 special character
        int specialCharCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasNumeric = true;
            } else if (isSpecialCharacter(c)) {
                specialCharCount++;
            }

            if (hasUpperCase && hasNumeric && specialCharCount == 1) {
                // All rules are satisfied, no need to continue checking
                return;
            }
        }

        // Check if Rule 2 (at least 1 uppercase) is not met
        if (!hasUpperCase) {
            throw new InvalidPasswordException3("Password must contain at least 1 uppercase character.");
        }

        // Check if Rule 3 (at least 1 numeric) is not met
        if (!hasNumeric) {
            throw new InvalidPasswordException3("Password must contain at least 1 numeric character.");
        }

        // Check if Rule 4 (exactly 1 special character) is not met
        if (specialCharCount != 1) {
            throw new InvalidPasswordException3("Password must contain exactly 1 special character.");
        }

        // Additional password rules can be added here.
    }

    private static boolean isSpecialCharacter(char c) {
        String specialCharacters = "!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?";
        return specialCharacters.contains(String.valueOf(c));
    }
}