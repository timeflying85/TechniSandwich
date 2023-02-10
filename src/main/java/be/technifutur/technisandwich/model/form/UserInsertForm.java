package be.technifutur.technisandwich.model.form;


import be.technifutur.technisandwich.model.entity.Panier;
import be.technifutur.technisandwich.model.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;

@Data
public class UserInsertForm {


    @NotNull
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private String password;



    public User toEntity() {

        User user = new User();

        user.setId( this.getId() );
        user.setPassword( this.getPassword() );
        user.setUsername( this.getUsername() );
        user.setFirstname( this.getFirstname() );
        user.setLastname( this.getLastname() );
        user.setOrders(new ArrayList<>());

        return user;

    }

}
