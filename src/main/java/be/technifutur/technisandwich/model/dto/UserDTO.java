package be.technifutur.technisandwich.model.dto;


import be.technifutur.technisandwich.model.entity.Order;
import be.technifutur.technisandwich.model.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String lastname;
    private String firstname;
    private List<OrderDTO> order;

    public static UserDTO from(User entity){

        if(entity == null)
            return null;

        return UserDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .firstname(entity.getFirstname())
                .lastname(entity.getLastname())
                .password(entity.getPassword())
                .order(entity.getOrders()
                        .stream()
                        .map(OrderDTO::from)
                        .collect(Collectors.toList()))
                .build();

    }


}
