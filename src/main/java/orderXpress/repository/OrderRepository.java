package orderXpress.repository;

import orderXpress.domain.Customer;
import orderXpress.domain.Order;
import orderXpress.domain.OrderDetail;
import orderXpress.domain.OrderStatus;

import java.util.List;

public interface OrderRepository {
    Order createOrder(Customer customer, List<OrderDetail> orderDetails);

    List<Order> getOrdersByCustomer(Customer customer);

    List<Order> getAllOrders();

    void updateOrderStatus(int orderId, OrderStatus status);
}
