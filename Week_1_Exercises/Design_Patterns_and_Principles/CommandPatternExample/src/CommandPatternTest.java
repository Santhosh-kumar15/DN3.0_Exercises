import java.util.Scanner;

public class CommandPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Light livingRoomLight = new Light();
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remoteControl = new RemoteControl();

        while (true) {
            System.out.println("\nHome Automation System:");
            System.out.println("1. Turn Light On");
            System.out.println("2. Turn Light Off");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    remoteControl.setCommand(lightOn);
                    remoteControl.pressButton();
                    break;
                case 2:
                    remoteControl.setCommand(lightOff);
                    remoteControl.pressButton();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
