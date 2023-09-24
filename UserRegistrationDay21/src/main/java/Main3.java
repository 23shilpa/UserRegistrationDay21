class InvalidMobileNumberException extends Exception {
    public InvalidMobileNumberException(String message) {
        super(message);
    }
}

public class Main3 {
    public static void main(String[] args) {
        try {
            String mobileNumber = enterMobileNumber();
            validateMobileNumber(mobileNumber);
            System.out.println("Valid mobile number: " + mobileNumber);
        } catch (InvalidMobileNumberException e) {
            System.out.println("Invalid mobile number: " + e.getMessage());
        }
    }

    public static String enterMobileNumber() {
        // You can use any method to get user input. Here, I'm using a simple example.
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter your mobile number: ");
        return scanner.nextLine();
    }

    public static void validateMobileNumber(String mobileNumber) throws InvalidMobileNumberException {
        // Regular expression pattern for a valid mobile number format
        String regex = "^\\d{2} \\d{10}$";

        if (!mobileNumber.matches(regex)) {
            throw new InvalidMobileNumberException("Invalid mobile number format.");
        }
    }
}




