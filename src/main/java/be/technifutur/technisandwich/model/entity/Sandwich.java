package be.technifutur.technisandwich.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter @Getter
@Table(name = "sandwich")
public class Sandwich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sandwich_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private String price;

    @OneToMany(mappedBy = "sandwich", cascade = CascadeType.ALL)
    private List<SandwichIngredient> sandwichIngredients;

    @ManyToMany
    private List<Regime> regimes;


}
