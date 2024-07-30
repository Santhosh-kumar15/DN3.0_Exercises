import java.util.Scanner;

public class ECommerceSorting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of orders: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter order ID: ");
            String orderId = scanner.nextLine();
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();
            System.out.print("Enter total price: ");
            double totalPrice = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        while (true) {
            System.out.println("\nSort Options:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Quick Sort");
            System.out.println("3. Exit");
            System.out.print("Choose a sorting method: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            Order[] ordersToSort = orders.clone();  // Clone the array to keep the original order intact
            long startTime = System.nanoTime();

            if (choice == 1) {
                BubbleSort.bubbleSort(ordersToSort);
            } else if (choice == 2) {
                QuickSort.quickSort(ordersToSort, 0, ordersToSort.length - 1);
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Sorted Orders:");
            for (Order order : ordersToSort) {
                System.out.println(order);
            }
            System.out.println("Sorting Time: " + duration + " nanoseconds");
        }

        scanner.close();
    }
}
