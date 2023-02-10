package be.technifutur.technisandwich.utils;


import be.technifutur.technisandwich.model.entity.*;
import be.technifutur.technisandwich.repository.*;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class DataInit implements InitializingBean {

    private final UserRepository userRepository;

    private final SandwichRepository sandwichRepository;

    private final IngredientRepository ingredientRepository;

    private final RegimeRepository regimeRepository;

    private final PasswordEncoder encoder;


    public DataInit(UserRepository userRepository, SandwichRepository sandwichRepository, OrderRepository orderRepository, IngredientRepository ingredientRepository, RegimeRepository regimeRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.sandwichRepository = sandwichRepository;
        this.ingredientRepository = ingredientRepository;
        this.regimeRepository = regimeRepository;
        this.encoder = encoder;
    }


    @Override
    public void afterPropertiesSet() throws Exception {


        // USER

        User user = new User();
        user.setId(1L);
        user.setRoles(Set.of("ADMIN"));
        user.setUsername("FlyingMan");
        user.setPassword(encoder.encode("youandme"));
        user.setFirstname("Timé");
        user.setLastname("Prégardien");
        user.setEnabled(true);
        userRepository.save(user);

        User user1 = new User();
        user1.setRoles(Set.of("USER"));
        user1.setLastname("Mederick");
        user1.setFirstname("Tom");
        user1.setUsername("Pitivier");
        user1.setId(2L);
        user1.setPassword(encoder.encode("565656"));
        user1.setEnabled(true);
        userRepository.save(user1);

        User user2 = new User();
        user2.setRoles(Set.of("USER"));
        user2.setLastname("NogDiep");
        user2.setFirstname("Nono");
        user2.setUsername("SweetAsian");
        user2.setId(3L);
        user2.setPassword(encoder.encode("565656"));
        user2.setEnabled(true);
        userRepository.save(user2);

        // REGIME

        Regime regime = new Regime();
        regime.setNom("Vegan");
        regime.setDescription("Comme tout le monde mais juste des plantes");
        regimeRepository.save(regime);

        Regime regime2 = new Regime();
        regime2.setNom("Vegetarien");
        regime2.setDescription("On mange tout ce qui est bon sauf les animaux");
        regimeRepository.save(regime2);

        Regime regime1 = new Regime();
        regime1.setNom("Vegetarien Poisson");
        regime1.setDescription("Pas animaux mais le poisson c'est trop bon donc on dit rien");
        regimeRepository.save(regime1);

        Regime regime3 = new Regime();
        regime3.setNom("Intolerant Lactose");
        regime3.setDescription("Si tu veux éviter la catastrophe, évite les produits laitiers");
        regimeRepository.save(regime3);

        Regime regime4 = new Regime();
        regime4.setNom("Intolerant Lactose");
        regime4.setDescription("Si tu veux éviter la catastrophe, évite les produits laitiers");
        regimeRepository.save(regime4);

        Regime regime5 = new Regime();
        regime5.setNom("Intolerant Gluten");
        regime5.setDescription("Si tu veux éviter la catastrophe, évite le Gluten");
        regimeRepository.save(regime5);

        // SANDWICH

        Sandwich sandwich = new Sandwich();
        sandwich.setId(1L);
        sandwich.setName("Dagobert");
        sandwich.setPrice("5euro");
        sandwich.setDescription("Le bon vieux classique");
        sandwich.setRegimes(List.of(regime5));
        sandwichRepository.save(sandwich);

        Sandwich sandwich1 = new Sandwich();
        sandwich1.setId(2L);
        sandwich1.setName("Americain Martino");
        sandwich1.setPrice("6euro");
        sandwich1.setDescription("Faits minutes pour une saveur unique");
        sandwich1.setRegimes(List.of(regime3));
        sandwichRepository.save(sandwich1);

        Sandwich sandwich2 = new Sandwich();
        sandwich2.setId(3L);
        sandwich2.setName("Le Parma");
        sandwich2.setPrice("7euro");
        sandwich2.setDescription("Toute la saveur de l'italie");
        sandwichRepository.save(sandwich2);

        Sandwich sandwich3 = new Sandwich();
        sandwich3.setId(4L);
        sandwich3.setName("Le Croquant");
        sandwich3.setPrice("6.5euro");
        sandwich3.setDescription("Le fameux poulet croquant et sa sauce");
        sandwich3.setRegimes(List.of(regime3));
        sandwichRepository.save(sandwich3);

        Sandwich sandwich4 = new Sandwich();
        sandwich4.setId(5L);
        sandwich4.setName("Le Tuna");
        sandwich4.setPrice("4euro");
        sandwich4.setDescription("La fraicheur du thon");
        sandwich4.setRegimes(List.of(regime1));
        sandwichRepository.save(sandwich4);

        // INGREDIENT

        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);
        ingredient.setName("Gouda Cheese");
        ingredientRepository.save(ingredient);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(2L);
        ingredient1.setName("Jambon à l'os");
        ingredientRepository.save(ingredient1);

        Ingredient ingredient2 =new Ingredient();
        ingredient2.setId(3L);
        ingredient2.setName("Mayonnaise");
        ingredientRepository.save(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(4L);
        ingredient3.setName("Filet Americain");
        ingredientRepository.save(ingredient3);

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setId(5L);
        ingredient4.setName("Jambon de Parme");
        ingredientRepository.save(ingredient4);

        Ingredient ingredient5 = new Ingredient();
        ingredient5.setId(6L);
        ingredient5.setName("Poulet Croquant");
        ingredientRepository.save(ingredient5);

        Ingredient ingredient6 = new Ingredient();
        ingredient6.setId(7L);
        ingredient6.setName("Salade");
        ingredientRepository.save(ingredient6);

        Ingredient ingredient7 = new Ingredient();
        ingredient7.setId(8L);
        ingredient7.setName("Tuna");
        ingredientRepository.save(ingredient7);

//        // ORDER
//
//        Order order = new Order();
//        order.setStatusOrder(StatusOrder.valueOf("EnPreparation"));
//        order.setId(1L);
//        order.setOrderDate(LocalDateTime.now());
//        orderRepository.save(order);
//
//        Order order1 = new Order();
//        order1.setStatusOrder(StatusOrder.valueOf("Livre"));
//        order1.setId(2L);
//        order1.setOrderDate(LocalDateTime.now());
//        orderRepository.save(order1);
//
//        Order order2 = new Order();
//        order2.setStatusOrder(StatusOrder.valueOf("EnLivraison"));
//        order2.setId(3L);
//        order2.setOrderDate(LocalDateTime.now());
//        orderRepository.save(order2);
//
//        Order order3 = new Order();
//        order3.setStatusOrder(StatusOrder.valueOf("EnAttente"));
//        order3.setId(4L);
//        order3.setOrderDate(LocalDateTime.now());
//        orderRepository.save(order3);
//
//        Order order4 = new Order();
//        order4.setStatusOrder(StatusOrder.valueOf("Annulee"));
//        order4.setId(5L);
//        order4.setOrderDate(null);
//        orderRepository.save(order4);


    }
}
