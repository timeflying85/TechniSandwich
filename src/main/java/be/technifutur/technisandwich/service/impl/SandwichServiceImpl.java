package be.technifutur.technisandwich.service.impl;

import be.technifutur.technisandwich.exceptions.RessourceNotFoundException;
import be.technifutur.technisandwich.model.dto.SandwichDTO;
import be.technifutur.technisandwich.model.entity.Ingredient;
import be.technifutur.technisandwich.model.entity.Sandwich;
import be.technifutur.technisandwich.model.entity.SandwichIngredient;
import be.technifutur.technisandwich.model.entity.User;
import be.technifutur.technisandwich.model.form.SandwichInsertForm;
import be.technifutur.technisandwich.repository.IngredientRepository;
import be.technifutur.technisandwich.repository.SandwichIngredientRepository;
import be.technifutur.technisandwich.repository.SandwichRepository;
import be.technifutur.technisandwich.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SandwichServiceImpl implements SandwichService {

    @Autowired
    private SandwichRepository sandwichRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private SandwichIngredientRepository sandwichIngredientRepository;


    @Override
    public void createSandwich(SandwichInsertForm form) {

        Sandwich sandwich = new Sandwich();

        sandwich.setId(form.getId());
        sandwich.setName(form.getName());
        sandwich.setPrice(form.getPrice());
        sandwich.setDescription(form.getDescription());

        sandwichRepository.save(sandwich);

        for (SandwichInsertForm.IngredientForm ingredient : form.getIngredients()) {
            Ingredient currentIngredient = ingredientRepository.findById(ingredient.getId()).orElseThrow(RessourceNotFoundException::new);
            SandwichIngredient sandwichIngredient = new SandwichIngredient();
            sandwichIngredient.setSandwich(sandwich);
            sandwichIngredient.setIngredient(currentIngredient);
            sandwichIngredient.setQuantity(ingredient.quantity);
            sandwichIngredientRepository.save(sandwichIngredient);
        }

    }

    @Override
    public SandwichDTO getOne(Long id) {

        Sandwich entity = sandwichRepository.findById(id).orElseThrow(RessourceNotFoundException::new);

        return SandwichDTO.from(entity);

    }

    @Override
    public List<SandwichDTO> getAll() {

        return sandwichRepository.findAll().stream().map(SandwichDTO::from).toList();

    }

    @Override
    public void delete(long id){

        sandwichRepository.deleteById(id);

    }

    @Override
    public void updateSandwich(long id, Map<String, String> updateData) {

        if(updateData == null || updateData.isEmpty())
            return;

        Sandwich sandwich = sandwichRepository.findById(id).orElseThrow(RessourceNotFoundException::new);

        if (updateData.containsKey("name")) {
            sandwich.setName(updateData.get("name"));
        }
        if (updateData.containsKey("price")) {
            sandwich.setPrice(updateData.get("price"));
        }
        if (updateData.containsKey("description")) {
            sandwich.setDescription(updateData.get("description"));
        }

        sandwichRepository.save(sandwich);

    }


}
