import java.util.Scanner;

public class AdapterPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Payment Gateway: ");
        System.out.println("1. PayPal");
        System.out.println("2. Stripe");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        System.out.print("Enter amount to pay: ");
        double amount = scanner.nextDouble();

        PaymentProcessor paymentProcessor = null;

        switch (choice) {
            case 1:
                PayPalGateway payPalGateway = new PayPalGateway();
                paymentProcessor = new PayPalAdapter(payPalGateway);
                break;
            case 2:
                StripeGateway stripeGateway = new StripeGateway();
                paymentProcessor = new StripeAdapter(stripeGateway);
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }

        if (paymentProcessor != null) {
            paymentProcessor.processPayment(amount);
        }

        scanner.close();
    }
}
