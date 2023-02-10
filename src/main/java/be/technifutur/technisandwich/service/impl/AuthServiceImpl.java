package be.technifutur.technisandwich.service.impl;


import be.technifutur.technisandwich.exceptions.FormValidationException;
import be.technifutur.technisandwich.jwt.JwtHolderDTO;
import be.technifutur.technisandwich.jwt.JwtProvider;
import be.technifutur.technisandwich.model.entity.Panier;
import be.technifutur.technisandwich.model.entity.User;
import be.technifutur.technisandwich.model.form.LoginForm;
import be.technifutur.technisandwich.model.form.RegistrationForm;
import be.technifutur.technisandwich.repository.PanierRepository;
import be.technifutur.technisandwich.repository.UserRepository;
import be.technifutur.technisandwich.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PanierRepository panierRepository;

    private final PasswordEncoder encoder;

    private final AuthenticationManager manager;

    private final JwtProvider jwtprovider;


    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder encoder, AuthenticationManager manager, JwtProvider jwtprovider, PanierRepository panierRepository) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.manager = manager;
        this.jwtprovider = jwtprovider;
        this.panierRepository = panierRepository;
    }

    @Override
    public void register(RegistrationForm form) {

        if (userRepository.existsByUsername((form.getUsername())))
            throw new FormValidationException("this username already exists");

        User user = form.toEntity();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);

        Panier panier = new Panier();
        panier.setSandwichs(new ArrayList<>());
        panier.setUser(user);
        panierRepository.save(panier);


    }

    @Override
    public JwtHolderDTO login(LoginForm form) {

        Authentication auth = new UsernamePasswordAuthenticationToken(
                form.getUsername(),
                form.getPassword()
        );

        manager.authenticate(auth);

        String token = jwtprovider.createToken(auth);

        return new JwtHolderDTO(token);

    }
}

