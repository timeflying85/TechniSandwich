package be.technifutur.technisandwich.controller;


import be.technifutur.technisandwich.model.dto.UserDTO;
import be.technifutur.technisandwich.model.form.UserInsertForm;
import be.technifutur.technisandwich.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    public void create(@RequestBody @Valid UserInsertForm form){

        userService.createUser( form );

    }

    @GetMapping("/{id:[0-9]+}")
    public UserDTO getOne(@PathVariable long id){

        return userService.getOne(id);

    }


    @GetMapping("/all")
    public List<UserDTO> getAll(){

        return userService.getAll();

    }



    @GetMapping("/{id:[0-9]+}/delete")
    public void delete(@PathVariable long id){

        userService.delete(id);

    }


    @PatchMapping("/{id:[0-9]+}/update")
    public void updateUser(@PathVariable long id, @RequestParam Map<String, String> params){

        userService.updateUser(id, params);

    }


}
