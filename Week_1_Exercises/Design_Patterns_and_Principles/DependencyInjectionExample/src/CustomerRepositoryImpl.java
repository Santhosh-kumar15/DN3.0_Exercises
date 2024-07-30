import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customerDatabase;

    public CustomerRepositoryImpl() {
        customerDatabase = new HashMap<>();
        // Adding some sample customers
        customerDatabase.put("1", new Customer("1", "Alice"));
        customerDatabase.put("2", new Customer("2", "Bob"));
    }

    @Override
    public Customer findCustomerById(String customerId) {
        return customerDatabase.get(customerId);
    }
}
