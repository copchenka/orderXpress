package orderXpress;

import orderXpress.configuration.HibernateConfiguration;
import orderXpress.domain.*;
import orderXpress.repository.CustomerRepository;
import orderXpress.repository.hbm.HibernateCustomerRepository;
import orderXpress.repository.hbm.HibernateOrderRepository;
import orderXpress.repository.hbm.HibernateProductRepository;

import java.util.List;

public class orderXpressApplication {
    public static void main(String[] args) {
        try {
            HibernateConfiguration.initializeSessionFactory();
            HibernateCustomerRepository customerRepository = new HibernateCustomerRepository(HibernateConfiguration.getFactory());
            HibernateOrderRepository orderRepository = new HibernateOrderRepository(HibernateConfiguration.getFactory());
            HibernateProductRepository productRepository = new HibernateProductRepository(HibernateConfiguration.getFactory());
            //Customer
//            List<Customer> customers = customerRepository.getAllCustomers();
//            for (Customer customer : customers) {
//                System.out.println(customer);
//            }
            //System.out.println(customerRepository.getCustomerById(1));
            //System.out.println(customerRepository.addCustomer("Маруся Песчанкина","Филлипова 15","marusya98@example.com","88003434343"));

//            List<Order> orders = orderRepository.getAllOrders();
//            for (Order order : orders) {
//                System.out.println(order);
//            }
//
//            Customer customer = customerRepository.getCustomerById(1);

//            List<Order> orders2 = orderRepository.getOrdersByCustomer(customer);
//            for (Order order : orders2) {
//                System.out.println(order);
//            }
//            List<OrderDetail> details = orderRepository.getOrderDetailsByOrderId(1);
//            for (OrderDetail detail : details) {
//                System.out.println(detail);
//            }

//            orderRepository.updateOrderStatus(1, OrderStatus.DELIVERED);
//            List<Order> orderList = orderRepository.getAllOrders();
//            for (Order order : orderList) {
//                System.out.println(order);
//            }

            //Product
//            List<Product> products = productRepository.getAllProducts();
//            for (Product product : products) {
//                System.out.println(product);
//            }
//
//            System.out.println(productRepository.getProductById(1));
        } finally {
            HibernateConfiguration.shutdown();
        }
    }
}
