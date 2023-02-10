package be.technifutur.technisandwich.model.form;

import be.technifutur.technisandwich.model.entity.Regime;
import be.technifutur.technisandwich.model.entity.Sandwich;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SandwichInsertForm {

    @Data
    @NoArgsConstructor
    public static class IngredientForm {
        public long id;
        public String quantity;
    }

    @NotNull
    private Long id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private String price;

    private List<IngredientForm> ingredients;

    private List<Long> regimeIds;


    public Sandwich toEntity(){

        Sandwich sandwich = new Sandwich();

        sandwich.setName( this.getName() );
        sandwich.setPrice( this.getPrice() );
        sandwich.setDescription( this.getDescription() );

        return sandwich;

    }



}
