import java.util.Scanner;

public class ECommerceSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter product ID: ");
            String productId = scanner.nextLine();
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();
            System.out.print("Enter product category: ");
            String category = scanner.nextLine();
            products[i] = new Product(productId, productName, category);
        }

        while (true) {
            System.out.println("\nSearch Options:");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            System.out.print("Choose a search method: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter the product name to search: ");
            String productNameToSearch = scanner.nextLine();

            Product result = null;
            if (choice == 1) {
                result = LinearSearch.linearSearch(products, productNameToSearch);
            } else if (choice == 2) {
                result = BinarySearch.binarySearch(products, productNameToSearch);
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            if (result != null) {
                System.out.println("Product found: " + result);
            } else {
                System.out.println("Product not found.");
            }
        }

        scanner.close();
    }
}
