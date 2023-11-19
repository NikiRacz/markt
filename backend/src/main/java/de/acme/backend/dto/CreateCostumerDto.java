package de.acme.backend.dto;

import de.acme.backend.domain.Costumer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCostumerDto {
    private String name;

    public Costumer dtoToEntity(CreateCostumerDto costumerDto){
        var costumer = new Costumer();
        costumer.setName(costumerDto.getName());
        return costumer;
    }

    public CreateCostumerDto entityToDto(Costumer costumer){
        var costumerDto = new CreateCostumerDto();
        costumerDto.setName(costumer.getName());
        return costumerDto;
    }
}
