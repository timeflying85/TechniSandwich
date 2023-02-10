package be.technifutur.technisandwich.controller;


import be.technifutur.technisandwich.model.dto.IngredientDTO;
import be.technifutur.technisandwich.model.form.IngredientInsertForm;
import be.technifutur.technisandwich.service.IngredientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private final IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/add")
    public void create(@RequestBody @Valid IngredientInsertForm form){

        ingredientService.addIngredient( form );

    }


    @GetMapping("/{id:[0-9]+}")
    public IngredientDTO getOne(@PathVariable long id){

        return ingredientService.getOne(id);

    }

    @GetMapping("/all")
    public List<IngredientDTO> getAll(){

        return ingredientService.getAll();

    }


    @DeleteMapping("/{id:[0-9]+}")
    public void delete(@PathVariable long id){

        ingredientService.delete(id);

    }


    @PatchMapping(value = "/{id:[0-9]+}/update", params = "name")
    public void updateName(@PathVariable long id,@RequestParam("name") String name){

        ingredientService.updateIngredient(id, name);

    }





}
