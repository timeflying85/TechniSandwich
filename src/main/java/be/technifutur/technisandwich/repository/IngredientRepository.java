package be.technifutur.technisandwich.repository;

import be.technifutur.technisandwich.model.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {


    @Modifying
    @Transactional // utile dans le cas d'un UPDATE/DELETE
    @Query("UPDATE Ingredient i SET i.name = ?2 WHERE i.id = ?1")
    void updateIngredient(long id, String name);

}
