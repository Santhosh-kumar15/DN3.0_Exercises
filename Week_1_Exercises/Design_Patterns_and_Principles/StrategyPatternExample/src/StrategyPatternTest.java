import java.util.Scanner;

public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Payment Methods:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.println("3. Exit");
            System.out.print("Select payment method:");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 3) {
                break;
            }

            System.out.print("Enter amount to pay: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Credit Card Number: ");
                    String cardNumber = scanner.nextLine();
                    System.out.print("Enter Card Holder Name: ");
                    String cardHolderName = scanner.nextLine();
                    System.out.print("Enter CVV: ");
                    String cvv = scanner.nextLine();
                    paymentContext.setPaymentStrategy(new CreditCardPayment(cardNumber, cardHolderName, cvv));
                    break;
                case 2:
                    System.out.print("Enter PayPal Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter PayPal Password: ");
                    String password = scanner.nextLine();
                    paymentContext.setPaymentStrategy(new PayPalPayment(email, password));
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            paymentContext.executePayment(amount);
        }

        scanner.close();
    }
}
