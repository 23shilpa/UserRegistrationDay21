class InvalidFirstNameException extends Exception {
    public InvalidFirstNameException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            String firstName = enterFirstName();
            validateFirstName(firstName);
            System.out.println("Valid First Name: " + firstName);
        } catch (InvalidFirstNameException e) {
            System.out.println("Invalid First Name: " + e.getMessage());
        }
    }

    public static String enterFirstName() {
        // You can use any method to get user input. Here, I'm using a simple example.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter your First Name: ");
        return scanner.nextLine();
    }

    public static void validateFirstName(String firstName) throws InvalidFirstNameException {
        if (firstName.length() < 3 || !Character.isUpperCase(firstName.charAt(0))) {
            throw new InvalidFirstNameException("First Name must start with a capital letter and have a minimum of 3 characters.");
        }
    }
}