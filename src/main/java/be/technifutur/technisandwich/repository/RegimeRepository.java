package be.technifutur.technisandwich.repository;

import be.technifutur.technisandwich.model.entity.Regime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegimeRepository extends JpaRepository<Regime, Long> {
}
