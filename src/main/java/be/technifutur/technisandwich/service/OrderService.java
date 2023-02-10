package be.technifutur.technisandwich.service;

import be.technifutur.technisandwich.model.dto.OrderDTO;
import be.technifutur.technisandwich.model.entity.Order;
import be.technifutur.technisandwich.model.entity.Panier;

import java.util.List;

public interface OrderService {

    Order createOrderFromPanier(String username);

    OrderDTO getOne(Long id);

    List<OrderDTO> getAll();

    void delete(long id);
}
