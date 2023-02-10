package be.technifutur.technisandwich.model.dto;


import be.technifutur.technisandwich.model.entity.Order;
import be.technifutur.technisandwich.model.entity.Panier;
import be.technifutur.technisandwich.model.entity.Sandwich;
import be.technifutur.technisandwich.model.entity.StatusOrder;
import be.technifutur.technisandwich.service.PanierService;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Builder
public class OrderDTO {

    private Long id;
    private LocalDateTime orderDate;
    private StatusOrder statusOrder;


    public static OrderDTO from(Order entity){
        if (entity == null)
            return null;

        return OrderDTO.builder()
                .id( entity.getId() )
                .statusOrder( entity.getStatusOrder() )
                .orderDate( entity.getOrderDate() )
                .build();
    }


    public Collection<Sandwich> getSandwich(PanierService panierService) {
        Panier panier = panierService.getPanier(this.id);
        return panier.getSandwichs();
    }
}
