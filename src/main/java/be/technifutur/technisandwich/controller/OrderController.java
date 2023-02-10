package be.technifutur.technisandwich.controller;


import be.technifutur.technisandwich.model.dto.OrderDTO;
import be.technifutur.technisandwich.service.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }


    @PostMapping("/add")
    public void create(Authentication authentication){

        service.createOrderFromPanier((String) authentication.getPrincipal());

    }

    @GetMapping("/all")
    public List<OrderDTO> getAll(){

        return service.getAll();

    }

    @GetMapping("/{id:[0-9]+}")
    public OrderDTO getOne(long id){

        return service.getOne(id);

    }

    @GetMapping("/{id:[0-9]+}/delete")
    public void delete(@PathVariable long id){

        service.delete(id);

    }




}
