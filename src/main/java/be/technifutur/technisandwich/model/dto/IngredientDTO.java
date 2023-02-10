package be.technifutur.technisandwich.model.dto;


import be.technifutur.technisandwich.model.entity.Ingredient;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientDTO {

    private Long id;
    private String name;


    public static IngredientDTO from(Ingredient entity){
        if (entity == null)
            return null;

        return IngredientDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();

    }

}
