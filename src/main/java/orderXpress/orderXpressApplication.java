package orderXpress;

import orderXpress.configuration.HibernateConfiguration;
import orderXpress.domain.Customer;
import orderXpress.repository.CustomerRepository;
import orderXpress.repository.hbm.HibernateCustomerRepository;

import java.util.List;

public class orderXpressApplication {
    public static void main(String[] args) {
        try {
            HibernateConfiguration.initializeSessionFactory();
            HibernateCustomerRepository customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
            //Customer
//            List<Customer> customers = customerRepository.getAllCustomers();
//            for (Customer customer : customers) {
//                System.out.println(customer);
//            }
            //System.out.println(customerRepository.getCustomerById(1));
            //System.out.println(customerRepository.addCustomer("Маруся Песчанкина","Филлипова 15","marusya98@example.com","88003434343"));


        } finally {
            HibernateConfiguration.shutdown();
        }
    }
}
