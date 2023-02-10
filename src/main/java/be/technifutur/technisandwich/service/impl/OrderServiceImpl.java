package be.technifutur.technisandwich.service.impl;

import be.technifutur.technisandwich.exceptions.RessourceNotFoundException;
import be.technifutur.technisandwich.model.dto.OrderDTO;
import be.technifutur.technisandwich.model.entity.*;
import be.technifutur.technisandwich.repository.OrderRepository;
import be.technifutur.technisandwich.repository.PanierRepository;
import be.technifutur.technisandwich.repository.SandwichRepository;
import be.technifutur.technisandwich.repository.UserRepository;
import be.technifutur.technisandwich.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SandwichRepository sandwichRepository;

    @Autowired
    private PanierRepository panierRepository;


    public Order createOrderFromPanier(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(RessourceNotFoundException::new);
        Panier panier = panierRepository.findByUser(user).orElseThrow(RessourceNotFoundException::new);
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setStatusOrder(StatusOrder.EnAttente);
        order.setUser(user);
        //if (panier.getSandwichs().size() == 0) throw new RuntimeException("pas de sandwich dans le panier");
        List<Sandwich> orderSandwichs = new ArrayList<>(panier.getSandwichs());
        order.setSandwiches(orderSandwichs);
        orderRepository.save(order);
        panier.setSandwichs(new ArrayList<>());
        panierRepository.save(panier);
        return order;
    }


    @Override
    public OrderDTO getOne(Long id) {

        Order order = orderRepository.findById(id).orElseThrow(RessourceNotFoundException::new);

        return OrderDTO.from(order);

    }

    @Override
    public List<OrderDTO> getAll() {

        return orderRepository.findAll().stream().map(OrderDTO::from).toList();

    }

    @Override
    public void delete(long id){

        orderRepository.deleteById(id);

    }




}
