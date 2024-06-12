package orderXpress.repository;

import orderXpress.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer addCustomer(String name, String address, String email, String phone);

    Customer getCustomerById(Integer customerId);

    List<Customer> getAllCustomers();

}
