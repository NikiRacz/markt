package de.acme.backend.service;

import de.acme.backend.domain.Costumer;
import de.acme.backend.dto.CreateCostumerDto;
import de.acme.backend.repository.CostumerRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {
    private static CostumerRepo costumerRepo;

    public CostumerService(CostumerRepo cs){ this.costumerRepo = cs;}

    public List<CreateCostumerDto> showAllCostumer(){
        var costumerDtoList = new ArrayList<CreateCostumerDto>();
        var costumerList = this.costumerRepo.findAll();
        costumerList.forEach((costumerEntity)->{
            CreateCostumerDto element = new CreateCostumerDto();
            costumerDtoList.add(element.entityToDto(costumerEntity));
        });
        return costumerDtoList;
    }

    public CreateCostumerDto newCostumer(CreateCostumerDto costumer){
        Costumer costumerEntity = costumer.dtoToEntity(costumer);
        Costumer costumerE = costumerRepo.save(costumerEntity);
        return costumer.entityToDto(costumerE);
    }

    public void deleteItem(Long id){
        this.costumerRepo.deleteById(id);
    }

    public CreateCostumerDto updateCostumer(long id, CreateCostumerDto costumer){
        Optional<Costumer> costumerToUpdate = this.costumerRepo.findById(id);
        Costumer newCostumer = costumerToUpdate.get();
        if(costumer.getName() != null){
            newCostumer.setName(costumer.getName());
        }
        this.costumerRepo.save(newCostumer);
        CreateCostumerDto costumerDto = costumer.entityToDto(newCostumer);
        return costumerDto;
    }
}
