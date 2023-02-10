package be.technifutur.technisandwich.service;

import be.technifutur.technisandwich.model.entity.Panier;
import be.technifutur.technisandwich.model.entity.User;
import be.technifutur.technisandwich.model.form.SandwichInsertForm;

public interface PanierService {

    Panier createPanierForUser(Panier panier, Long id);

    Panier getPanier(Long id);

    void createOrderFromPanier(Panier panier);

    void clearPanier(Long id);

    void update(Panier panier);

    void save(Panier panier);

    Panier findByUser(User user);

    void addSandwich(SandwichInsertForm form);

    void addSandwichToPanier(long id, String username);

}
