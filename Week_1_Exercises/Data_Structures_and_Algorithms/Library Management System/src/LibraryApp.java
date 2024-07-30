import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagementSystem lms = new LibraryManagementSystem(10);

        // Adding sample books
        lms.addBook(new Book("B001", "Java Programming", "John Doe"));
        lms.addBook(new Book("B002", "Python Programming", "Jane Smith"));
        lms.addBook(new Book("B003", "Algorithms", "Emily Davis"));

        // Displaying all books
        System.out.println("All Books:");
        lms.displayBooks();

        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Linear Search by Title");
            System.out.println("3. Binary Search by Title");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    lms.addBook(new Book(bookId, title, author));
                    System.out.println("Book added successfully!!");
                    break;

                case 2:
                    System.out.print("Enter Book Title to search (Linear Search): ");
                    String searchTitleLinear = scanner.nextLine();
                    Book foundBookLinear = lms.linearSearchByTitle(searchTitleLinear);
                    if (foundBookLinear != null) {
                        System.out.println("Book found: " + foundBookLinear);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book Title to search (Binary Search): ");
                    String searchTitleBinary = scanner.nextLine();
                    Book foundBookBinary = lms.binarySearchByTitle(searchTitleBinary);
                    if (foundBookBinary != null) {
                        System.out.println("Book found: " + foundBookBinary);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.println("All Books:");
                    lms.displayBooks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
