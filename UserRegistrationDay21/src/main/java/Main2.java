class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

public class Main2 {
    public static void main(String[] args) {
        try {
            String email = enterEmail();
            validateEmail(email);
            System.out.println("Valid email: " + email);
        } catch (InvalidEmailException e) {
            System.out.println("Invalid email: " + e.getMessage());
        }
    }

    public static String enterEmail() {
        // You can use any method to get user input. Here, I'm using a simple example.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter your email: ");
        return scanner.nextLine();
    }

    public static void validateEmail(String email) throws InvalidEmailException {
        // Regular expression pattern for a valid email address
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        if (!email.matches(regex)) {
            throw new InvalidEmailException("Invalid email format.");
        }

        // Split the email into parts
        String[] parts = email.split("@");
        if (parts.length != 2) {
            throw new InvalidEmailException("Invalid email format.");
        }

        String[] domainParts = parts[1].split("\\.");
        if (domainParts.length < 2 || domainParts.length > 3) {
            throw new InvalidEmailException("Invalid email format.");
        }

        if (!domainParts[0].equals("bl") || !domainParts[1].equals("co")) {
            throw new InvalidEmailException("Invalid email format.");
        }

        if (domainParts.length == 3 && !domainParts[2].equals("in")) {
            throw new InvalidEmailException("Invalid email format.");
        }
    }
}