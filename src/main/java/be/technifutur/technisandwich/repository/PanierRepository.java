package be.technifutur.technisandwich.repository;

import be.technifutur.technisandwich.model.entity.Panier;
import be.technifutur.technisandwich.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PanierRepository extends JpaRepository<Panier, Long> {

    Optional<Panier> findByUser(User user);


}
