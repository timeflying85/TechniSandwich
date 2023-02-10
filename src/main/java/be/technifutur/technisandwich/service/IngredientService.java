package be.technifutur.technisandwich.service;

import be.technifutur.technisandwich.model.dto.IngredientDTO;
import be.technifutur.technisandwich.model.form.IngredientInsertForm;
import jakarta.validation.Valid;

import java.util.List;

public interface IngredientService {

    void addIngredient(@Valid IngredientInsertForm form);

    IngredientDTO getOne(Long id);

    List<IngredientDTO> getAll();

    void delete(long id);

    void updateIngredient(long id, String name);

}
