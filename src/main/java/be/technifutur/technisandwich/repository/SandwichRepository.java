package be.technifutur.technisandwich.repository;

import be.technifutur.technisandwich.model.entity.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SandwichRepository extends JpaRepository<Sandwich, Long> {
}
