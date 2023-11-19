package de.acme.backend.controller;

import de.acme.backend.domain.Costumer;
import de.acme.backend.dto.CreateCostumerDto;
import de.acme.backend.repository.CostumerRepo;
import de.acme.backend.service.CostumerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("costumer")
public class CostumerController {
    private static CostumerService costumerService;

    public CostumerController(CostumerService cs) {
        this.costumerService = cs;
    }

    @GetMapping("all")
    public List<CreateCostumerDto> showAll(){
        return this.costumerService.showAllCostumer();
    }

    @PostMapping("new")
    public CreateCostumerDto createNew(@RequestBody CreateCostumerDto costumer){
        return this.costumerService.newCostumer(costumer);
    }

    @DeleteMapping("costumer/{id}")
    public void deleteCostumer(@PathVariable("id") long id){
        this.costumerService.deleteItem(id);
    }

    @PutMapping("costumer/{id}")
    public CreateCostumerDto updateCostumer(@PathVariable("id") long id, @RequestBody CreateCostumerDto costumer){
        return this.costumerService.updateCostumer(id, costumer);
    }
}
