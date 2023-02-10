package be.technifutur.technisandwich.model.dto;


import be.technifutur.technisandwich.model.entity.Regime;
import be.technifutur.technisandwich.model.entity.Sandwich;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class SandwichDTO {

    @Data
    @Builder
    public static class RegimeDTO {
        private Long id;
        private String nom;
        private String description;

        public static RegimeDTO from(Regime entity) {
            if( entity== null )
                return null;

            return RegimeDTO.builder()
                    .id(entity.getId())
                    .nom(entity.getNom())
                    .description(entity.getDescription())
                    .build();
        }
    }

    private Long id;
    private String name;
    private String price;
    private String description;
    private List<RegimeDTO> regimes;


    public static SandwichDTO from(Sandwich entity){
        if( entity== null )
            return null;

        return SandwichDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .regimes(entity.getRegimes()
                        .stream()
                        .map(RegimeDTO::from)
                        .collect(Collectors.toList()))
                .build();

    }

}
