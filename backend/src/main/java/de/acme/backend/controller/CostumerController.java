package de.acme.backend.controller;

import de.acme.backend.domain.Costumer;
import de.acme.backend.service.CostumerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("costumer")
public class CostumerController {
    private static CostumerService costumerService;

    @GetMapping("all")
    public List<Costumer> showAll(){
        return this.costumerService.showAllCostumer();
    }

    @PostMapping("new")
    public Costumer createNew(@RequestBody Costumer costumer){
        return this.costumerService.newCostumer(costumer);
    }

    @DeleteMapping("costumer/{id}")
    public void deleteCostumer(@PathVariable("id") long id){
        this.costumerService.deleteItem(id);
    }

    @PutMapping("costumer/{id}")
    public Costumer updateCostumer(@PathVariable("id") long id, @RequestBody Costumer costumer){
        return this.costumerService.updateCostumer(id, costumer);
    }
}
