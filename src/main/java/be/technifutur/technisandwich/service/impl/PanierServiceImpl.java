package be.technifutur.technisandwich.service.impl;


import be.technifutur.technisandwich.exceptions.RessourceNotFoundException;
import be.technifutur.technisandwich.model.entity.*;
import be.technifutur.technisandwich.model.form.SandwichInsertForm;
import be.technifutur.technisandwich.repository.OrderRepository;
import be.technifutur.technisandwich.repository.PanierRepository;
import be.technifutur.technisandwich.repository.SandwichRepository;
import be.technifutur.technisandwich.repository.UserRepository;
import be.technifutur.technisandwich.service.PanierService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class PanierServiceImpl implements PanierService {
    private final PanierRepository panierRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final SandwichRepository sandwichRepository;





    public PanierServiceImpl(PanierRepository panierRepository, UserRepository userRepository, OrderRepository orderRepository, SandwichRepository sandwichRepository) {
        this.panierRepository = panierRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.sandwichRepository = sandwichRepository;
    }

    public Panier createPanierForUser(Panier panier, Long id) {
        User user = userRepository.findById(id).orElseThrow(RessourceNotFoundException::new);

        Panier panier1 = new Panier();
        panier1.setUser(user);
        user.setPanier(panier1);

        return panierRepository.save(panier1);
    }

    @Override
    public Panier getPanier(Long id) {
        return panierRepository.findById(id)
                .orElseThrow(RessourceNotFoundException::new);
    }

    @Override
    public void createOrderFromPanier(Panier panier) {

//        OrderInsertForm orderInsertForm = new OrderInsertForm();
//        orderInsertForm.setOrderDate(new Date());
//        orderInsertForm.set(panier.getUser());
//
//        // convertir la liste de sandwichs du panier en une liste de SandwichInsertForm
//        List<SandwichInsertForm> sandwichInsertForms = panier.getSandwichs().stream()
//                .map(sandwich -> {
//                    SandwichInsertForm form = new SandwichInsertForm();
//                    form.setName(sandwich.getName());
//                    form.setPrice(sandwich.getPrice());
//                    return form;
//                })
//                .collect(Collectors.toList());
//        orderInsertForm.setSandwichs(sandwichInsertForms);
//
//        // appeler la méthode createOrder du OrderService pour enregistrer l'Order
//        orderRepository.create(orderInsertForm);

//        Panier panier = new Panier();
//
//        User user = userService.getUser(panier.getUserId());
//        panier.setUser(user);
//
//        panier = panierRepository.save(panier);
//
//        List<Sandwich> sandwiches = new ArrayList<>();
//        for (Long id : panier.getSandwichIds()) {
//            sandwiches.add(sandwichService.getOne(id));
//        }
//        panier.setSandwich(sandwiches);
//
//        return panierRepository.save(panier);
    }

    @Override
    public void clearPanier(Long id) {

        User user = userRepository.findById(id).orElseThrow(RessourceNotFoundException::new);
        Panier panier = panierRepository.findByUser(user).orElseThrow(RessourceNotFoundException::new);
        List<Sandwich> sandwiches = panier.getSandwichs();

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatusOrder(StatusOrder.EnAttente);
        order.setSandwiches(sandwiches);

        orderRepository.save(order);

        panier.clear();
        panierRepository.save(panier);

    }

    @Override
    public void update(Panier panier) {

        if (!panierRepository.existsById(panier.getId())) {
            throw new RessourceNotFoundException();
        }

        panierRepository.save(panier);

    }

    @Override
    public void save(Panier panier) {

        panierRepository.save(panier);

    }

    @Override
    public Panier findByUser(User user) {
        Optional<Panier> optionalPanier = panierRepository.findByUser(user);
        return optionalPanier.orElse(new Panier());
    }

    @Override
    public void addSandwich(SandwichInsertForm form) {
        Sandwich sandwich = new Sandwich();
        sandwich.setName(form.getName());
        sandwich.setPrice(form.getPrice());
        sandwich.setDescription(form.getDescription());
//        sandwich.setIngredients(form.toEntity().getIngredients());

        sandwichRepository.save(sandwich);

    }

    @Override
    public void addSandwichToPanier(long id, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(RessourceNotFoundException::new);
        Optional<Panier> panier = panierRepository.findByUser(user);
        if(panier.isPresent()) {
            Sandwich sandwich = sandwichRepository.findById(id).orElseThrow(RessourceNotFoundException::new);
            panier.get().getSandwichs().add(sandwich);
            panierRepository.save(panier.get());
        }
        else {
            throw new RessourceNotFoundException();
        }
    }

}
