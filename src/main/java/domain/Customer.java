package domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "email")
    String email;
    @Column(name = "phone")
    String phone;
    @Column(name = "address")
    String address;
    @OneToMany(
            mappedBy = "customer",
            fetch = FetchType.LAZY
    )
    private List<Order> orders;


    public Customer(Integer id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

}
