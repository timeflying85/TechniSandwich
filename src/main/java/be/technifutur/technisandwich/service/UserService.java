package be.technifutur.technisandwich.service;

import be.technifutur.technisandwich.model.dto.UserDTO;
import be.technifutur.technisandwich.model.entity.User;
import be.technifutur.technisandwich.model.form.UserInsertForm;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

public interface UserService {

    void createUser(@Valid UserInsertForm form);

    UserDTO getOne(Long id);

    List<UserDTO> getAll();

    void delete(long id);

    User getUserById(Long id);

    void updateUser(long id, Map<String, String> updateData);


}
