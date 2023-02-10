package be.technifutur.technisandwich.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long id;

    private LocalDateTime orderDate;

    private LocalDateTime deliveryTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOrder statusOrder;

    private String discount;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
            name = "order_sandwich",
            joinColumns = @JoinColumn(name = "sandwich_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Sandwich> sandwiches;

}
