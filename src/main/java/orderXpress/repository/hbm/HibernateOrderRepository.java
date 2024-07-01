package orderXpress.repository.hbm;

import orderXpress.domain.Customer;
import orderXpress.domain.Order;
import orderXpress.domain.OrderDetail;
import orderXpress.domain.OrderStatus;
import orderXpress.repository.OrderRepository;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;


public class HibernateOrderRepository extends AbstractRepository implements OrderRepository {
    public HibernateOrderRepository(SessionFactory factory) {
        super(factory);
    }

    @Override
    public Order createOrder(Customer customer, List<OrderDetail> orderDetails) {
        return withTransaction(session -> {
            BigDecimal totalCost = BigDecimal.valueOf(0);
            for (OrderDetail orderDetail : orderDetails) {
                totalCost.add(BigDecimal.valueOf(orderDetail.getQuantity() * orderDetail.getUnitPrice()));
            }
            //Add order details in table
            Order order = new Order(
                    null,
                    customer.getId(),
                    totalCost,
                    OrderStatus.PENDING,
                    Date.valueOf(String.valueOf(LocalDateTime.now())),
                    orderDetails
            );
            session.persist(order);
            return order;
        });
    }

    @Override
    public List<Order> getOrdersByCustomer(Customer customer) {
        return withTransaction(session -> session.createQuery("from Order where customer_id = :customer_id", Order.class)
                .setParameter("customer_id", customer.getId())
                .list());
    }

    @Override
    public List<Order> getAllOrders() {
        return withSession(session -> session.createQuery("from Order", Order.class)
                .list());
    }

    @Override
    public void updateOrderStatus(int orderId, OrderStatus status) {
        withTransaction(session -> {
            Order order = session.get(Order.class, orderId);
            if (order != null) {
                order.setStatus(status);
                session.update(order);
            } else {
                throw new IllegalArgumentException("Order with id " + orderId + " not found.");
            }
            return null;
        });
    }


    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        return withSession(session -> session.createQuery("from OrderDetail where order.id = :order_id", OrderDetail.class)
                .setParameter("order_id", orderId)
                .list());
    }
}

