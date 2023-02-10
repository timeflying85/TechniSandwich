package be.technifutur.technisandwich.service;

import be.technifutur.technisandwich.jwt.JwtHolderDTO;
import be.technifutur.technisandwich.model.form.LoginForm;
import be.technifutur.technisandwich.model.form.RegistrationForm;
import jakarta.validation.Valid;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthService {

    void register(@Valid RegistrationForm form);


    JwtHolderDTO login(LoginForm form);


}
