class InvalidEmailException1 extends Exception {
    public InvalidEmailException1(String message) {
        super(message);
    }
}

public class Main8 {
    public static void main(String[] args) {
        // List of email samples
        String[] emailSamples = {
                "abc.xyz@bl.co.in",
                "invalid_email",
                "john.doe@example.com",
                // Add more email samples here
        };

        for (String email : emailSamples) {
            try {
                validateAndClearEmail(email);
                System.out.println("Valid email: " + email);
            } catch (InvalidEmailException1 e) {
                System.out.println("Invalid email: " + e.getMessage());
            }
        }
    }

    public static void validateAndClearEmail(String email) throws InvalidEmailException1 {
        // Regular expression pattern for a valid email address
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        if (!email.matches(regex)) {
            throw new InvalidEmailException1("Invalid email format.");
        }

        // Additional validation logic can be added here

        // If the email is valid, you can clear it (if clearing means something specific)
        // For example, you can clear it by setting it to an empty string or null
        email = "";
    }
}