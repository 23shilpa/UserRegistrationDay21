class InvalidLastNameException extends Exception {
    public InvalidLastNameException(String message) {
        super(message);
    }
}

public class Main1 {
    public static void main(String[] args) {
        try {
            String lastName = enterLastName();
            validateLastName(lastName);
            System.out.println("Valid Last Name: " + lastName);
        } catch (InvalidLastNameException e) {
            System.out.println("Invalid Last Name: " + e.getMessage());
        }
    }

    public static String enterLastName() {
        // You can use any method to get user input. Here, I'm using a simple example.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter your Last Name: ");
        return scanner.nextLine();
    }

    public static void validateLastName(String lastName) throws InvalidLastNameException {
        if (lastName.length() < 3 || !Character.isUpperCase(lastName.charAt(0))) {
            throw new InvalidLastNameException("Last Name must start with a capital letter and have a minimum of 3 characters.");
        }
    }
}