package be.technifutur.technisandwich.model.form;


import be.technifutur.technisandwich.model.entity.Order;
import be.technifutur.technisandwich.model.entity.Sandwich;
import be.technifutur.technisandwich.model.entity.StatusOrder;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderInsertForm {

    @NotNull
    private long id;

    @NotNull
    private String name;

    @NotNull
    @Future
    private LocalDateTime orderDate;

    @Future
    private LocalDateTime deliveryTime;

    @NotNull
    private StatusOrder statusOrder;

    private String discount;

    private List<Sandwich> sandwiches;

    public List<Sandwich> getSandwich() {
        return sandwiches;
    }
    public void setSandwich(List<Sandwich> sandwich) {
        this.sandwiches = sandwich;
    }


    public Order toEntity(){

        Order order = new Order();

        order.setOrderDate( this.getOrderDate() );
        order.setStatusOrder( this.getStatusOrder() );
        order.setDeliveryTime( this.getDeliveryTime() );

        return order;

    }



}
