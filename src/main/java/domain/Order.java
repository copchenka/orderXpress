package domain;

import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Order {
    private Integer id;
    private Integer customer_id;
    private Long totalCost;
    private String status;
    private Date creationDate;
    private List<OrderDetail> orderDetails;
}
