package be.technifutur.technisandwich.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    private List<SandwichIngredient> sandwichIngredients;

}
