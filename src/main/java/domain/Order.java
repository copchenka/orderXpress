package domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;
    @Column(name = "customer_id")
    private Integer customer_id;
    @Column(name = "total_cost")
    private Long totalCost;
    @Column(name = "status")
    private OrderStatus status;
    @Column(name = "creation_date")
    private Date creationDate;
    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderDetail> orderDetails;



    public Order( Integer customer_id, Long totalCost, OrderStatus status, Date creationDate, List<OrderDetail> orderDetails) {
        this.customer_id = customer_id;
        this.totalCost = totalCost;
        this.status = status;
        this.creationDate = creationDate;
        this.orderDetails = orderDetails;
    }
}
