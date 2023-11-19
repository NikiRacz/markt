package de.acme.backend.service;

import de.acme.backend.domain.Costumer;
import de.acme.backend.repository.CostumerRepo;

import java.util.List;
import java.util.Optional;

public class CostumerService {
    private static CostumerRepo costumerRepo;

    public CostumerService(CostumerRepo cs){ this.costumerRepo = cs;}

    public List<Costumer> showAllCostumer(){
        return this.costumerRepo.findAll();
    }

    public Costumer newCostumer(Costumer costumer){
        return this.costumerRepo.save(costumer);
    }

    public void deleteItem(Long id){
        this.costumerRepo.deleteById(id);
    }

    public Costumer updateCostumer(long id, Costumer costumer){
        Optional<Costumer> costumerToUpdate = this.costumerRepo.findById(id);
        Costumer newCostumer = costumerToUpdate.get();
        if(costumer.getName() != null){
            newCostumer.setName(costumer.getName());
        }
        return this.costumerRepo.save(newCostumer);
    }
}
