package domain;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Double price;
}
