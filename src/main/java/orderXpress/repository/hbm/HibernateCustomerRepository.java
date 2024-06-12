package orderXpress.repository.hbm;

import orderXpress.domain.Customer;
import orderXpress.repository.CustomerRepository;
import org.hibernate.SessionFactory;


import java.util.List;


public class HibernateCustomerRepository extends AbstractRepository implements CustomerRepository {
    public HibernateCustomerRepository(SessionFactory factory) {
        super(factory);
    }

    @Override
    public Customer addCustomer(String name, String address, String email, String phone) {
        return withTransaction(session -> {
            Customer customer = new Customer(null, name, email, phone, address);
            session.persist(customer);
            return customer;
        });
    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return withSession(session -> session
                .get(Customer.class, customerId));
    }


    @Override
    public List<Customer> getAllCustomers() {
        return withSession(session -> session.createQuery("from Customer", Customer.class)
                .list());
    }
}
