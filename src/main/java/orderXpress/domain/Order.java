package orderXpress.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString(
        exclude = {"orderDetails",
                "customer"
        }
)
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
    private BigDecimal totalCost;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;
    @Column(name = "creation_date")
    private Date creationDate;
    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<OrderDetail> orderDetails;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false, insertable = false, updatable = false)
    private Customer customer;

    public Order(Integer id, Integer customer_id, BigDecimal totalCost, OrderStatus status, Date creationDate, List<OrderDetail> orderDetails) {
        this.id = id;
        this.customer_id = customer_id;
        this.totalCost = totalCost;
        this.status = status;
        this.creationDate = creationDate;
        this.orderDetails = orderDetails;
    }
}
