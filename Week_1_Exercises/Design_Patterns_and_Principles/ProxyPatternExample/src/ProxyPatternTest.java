import java.util.Scanner;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the image path: ");
        String imagePath = scanner.nextLine();

        Image image = new ProxyImage(imagePath);

        System.out.println("Displaying image for the first time:");
        image.display(); // Loading from server

        System.out.println("Displaying image again:");
        image.display(); // Using cached image

        scanner.close();
    }
}
