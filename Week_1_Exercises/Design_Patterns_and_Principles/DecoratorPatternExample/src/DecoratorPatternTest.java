import java.util.Scanner;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        Notifier notifier = new EmailNotifier();

        System.out.println("Choose Notification Channels (comma separated): ");
        System.out.println("1. Email");
        System.out.println("2. SMS");
        System.out.println("3. Slack");
        System.out.print("Enter your choice (e.g., 1,2): ");
        String[] choices = scanner.nextLine().split(",");

        for (String choice : choices) {
            switch (choice.trim()) {
                case "1":
                    break; // EmailNotifier is already the base
                case "2":
                    notifier = new SMSNotifierDecorator(notifier);
                    break;
                case "3":
                    notifier = new SlackNotifierDecorator(notifier);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    scanner.close();
                    return;
            }
        }

        notifier.send(message);
        scanner.close();
    }
}
