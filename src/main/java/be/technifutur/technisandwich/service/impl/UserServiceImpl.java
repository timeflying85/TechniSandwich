package be.technifutur.technisandwich.service.impl;


import be.technifutur.technisandwich.exceptions.RessourceNotFoundException;
import be.technifutur.technisandwich.model.dto.UserDTO;
import be.technifutur.technisandwich.model.entity.Panier;
import be.technifutur.technisandwich.model.entity.User;
import be.technifutur.technisandwich.model.form.UserInsertForm;
import be.technifutur.technisandwich.repository.OrderRepository;
import be.technifutur.technisandwich.repository.PanierRepository;
import be.technifutur.technisandwich.repository.UserRepository;
import be.technifutur.technisandwich.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final OrderRepository orderRepository;

    private final PanierRepository panierRepository;

    public UserServiceImpl(UserRepository userRepository, OrderRepository orderRepository, PanierRepository panierRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.panierRepository = panierRepository;
    }


    @Override
    public void createUser(UserInsertForm form) {

        User user = form.toEntity();
        userRepository.save(user);

        Panier panier = new Panier();
        panier.setSandwichs(new ArrayList<>());
        panier.setUser(user);
        panierRepository.save(panier);

    }

    @Override
    public UserDTO getOne(Long id) {
        User entity = userRepository.findById(id).orElseThrow(RessourceNotFoundException::new);
        return UserDTO.from(entity);
    }


    @Override
    public List<UserDTO> getAll() {

        return userRepository.findAll().stream().map(UserDTO::from).toList();
    }


    @Override
    public void delete(long id){

        userRepository.deleteById(id);

    }

    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id).orElse(null);

    }


    @Override
    public void updateUser(long id, Map<String, String> updateData){

        if(updateData == null || updateData.isEmpty())
            return;

        User user = userRepository.findById(id).orElseThrow(RessourceNotFoundException::new);

        if (updateData.containsKey("firstname")) {
            user.setFirstname(updateData.get("firstname"));
        }
        if (updateData.containsKey("lastname")) {
            user.setLastname(updateData.get("lastname"));
        }
        if (updateData.containsKey("username")) {
            user.setUsername(updateData.get("username"));
        }
        if (updateData.containsKey("password")) {
            user.setFirstname(updateData.get("password"));
        }

        userRepository.save(user);
    }

}
