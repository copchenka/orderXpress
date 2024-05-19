package domain;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Customer {
    Integer id;
    String name;
    String email;
    String phone;
    String address;
}
