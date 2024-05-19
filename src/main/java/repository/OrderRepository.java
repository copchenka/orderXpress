package repository;

import domain.Customer;
import domain.Order;
import domain.OrderDetail;

import java.util.List;

public interface OrderRepository {
    Order createOrder(Customer customer, List<OrderDetail> orderDetails);

    List<Order> getOrdersByCustomer(Customer customer);

    List<Order> getAllOrders();

    void updateOrderStatus(int orderId, String status);
}
