package domain;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderDetail {
    private Integer id;
    private Integer order_id;
    private Integer product_id;
    private Integer quantity;
    private Double unitPrice;
}
