package de.acme.backend.controller;

import de.acme.backend.dto.CreatePurchaseDto;
import de.acme.backend.service.PurchaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("purchase")
public class PurchaseController {
    private static PurchaseService purchaseService;

    public PurchaseController(PurchaseService ps){this.purchaseService = ps;}

    @GetMapping("all")
    public List<CreatePurchaseDto> getAll(){
        return this.purchaseService.showAllPurchases();
    }

    @PostMapping("new")
    public CreatePurchaseDto addPurchases(@RequestBody CreatePurchaseDto purchase){
        return this.purchaseService.newPurchase(purchase);
    }

    @DeleteMapping("purchase/{id}")
    public void deletePurchase(@PathVariable("id") long id){
        this.purchaseService.deletePurchase(id);
    }

    @PutMapping("purchase/{id}")
    public CreatePurchaseDto updatePurchase(@PathVariable("id") long id, @RequestBody CreatePurchaseDto purchase){
        return this.purchaseService.updatePurchase(id, purchase);
    }
}
