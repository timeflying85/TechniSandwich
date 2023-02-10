package be.technifutur.technisandwich.repository;

import be.technifutur.technisandwich.model.entity.SandwichIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichIngredientRepository extends JpaRepository<SandwichIngredient, Long> {

}
