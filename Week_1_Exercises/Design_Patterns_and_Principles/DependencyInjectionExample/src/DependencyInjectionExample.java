import java.util.Scanner;

public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create repository instance
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject repository into service
        CustomerService customerService = new CustomerService(customerRepository);

        // User input for customer ID
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer ID to search: ");
        String customerId = scanner.nextLine();

        // Find and display customer
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            System.out.println("Customer found: " + customer);
        } else {
            System.out.println("Customer not found.");
        }

        scanner.close();
    }
}
