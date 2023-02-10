package be.technifutur.technisandwich.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "panier_id", nullable = false)
    private Long id;

    @OneToOne
    private User user;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "panier_id"),
            inverseJoinColumns = @JoinColumn(name = "sandwich_id")
    )
    private List<Sandwich> sandwichs;


    public void setUser(User user) {
        this.user = user;
        user.setPanier(this);
    }

    public void clear() {
        this.sandwichs.clear();
    }


//    List<Long> sandwichIds = new ArrayList<>();
//    for (Sandwich sandwich : this.sandwich) {
//        sandwichIds.add(sandwich.getId());
//    }
//    return sandwichIds;

}
