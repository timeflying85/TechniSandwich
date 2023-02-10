package be.technifutur.technisandwich.service.impl;

import be.technifutur.technisandwich.exceptions.RessourceNotFoundException;
import be.technifutur.technisandwich.model.dto.IngredientDTO;
import be.technifutur.technisandwich.model.entity.Ingredient;
import be.technifutur.technisandwich.model.form.IngredientInsertForm;
import be.technifutur.technisandwich.repository.IngredientRepository;
import be.technifutur.technisandwich.repository.SandwichRepository;
import be.technifutur.technisandwich.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {


    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private SandwichRepository sandwichRepository;



    @Override
    public void addIngredient(IngredientInsertForm form) {

        Ingredient ingredient = new Ingredient();
        ingredient.setId( form.getId() );
        ingredient.setName( form.getName() );

        ingredientRepository.save(ingredient);

    }

    @Override
    public IngredientDTO getOne(Long id) {

        return ingredientRepository.findById(id)
                .map( IngredientDTO::from )
                .orElseThrow( RessourceNotFoundException::new );

    }

    @Override
    public List<IngredientDTO> getAll() {

        return ingredientRepository.findAll().stream().map(IngredientDTO::from).toList();

    }

    @Override
    public void delete(long id){

        ingredientRepository.deleteById(id);

    }

    @Override
    public void updateIngredient(long id, String name){

        if( !ingredientRepository.existsById(id) ){
            throw new RessourceNotFoundException();
        }

        ingredientRepository.updateIngredient(id, name);

    }


}
