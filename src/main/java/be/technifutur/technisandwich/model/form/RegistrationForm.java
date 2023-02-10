package be.technifutur.technisandwich.model.form;


import be.technifutur.technisandwich.model.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class RegistrationForm {

    @NotNull
    private String username;

    @NotNull
    @Size(min = 4)
    private String password;

    private String firstname;
    private String lastname;

    public User toEntity(){

        User user = new User();
        user.setUsername( username );
        user.setPassword( password );
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setRoles( Set.of("USER") );

        return user;

    }

}
