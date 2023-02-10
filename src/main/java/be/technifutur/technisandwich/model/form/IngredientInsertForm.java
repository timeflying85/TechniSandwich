package be.technifutur.technisandwich.model.form;


import be.technifutur.technisandwich.model.entity.Ingredient;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IngredientInsertForm {

    @NotNull
    private Long id;

    @NotNull
    private String name;


    public Ingredient toEntity(){

        Ingredient ingredient = new Ingredient();

        ingredient.setId( this.getId() );
        ingredient.setName( this.getName() );

        return ingredient;

    }


}
