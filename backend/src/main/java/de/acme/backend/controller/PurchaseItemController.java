package de.acme.backend.controller;

import de.acme.backend.dto.CreateCostumerDto;
import de.acme.backend.dto.CreatePurchaseItemDto;
import de.acme.backend.service.PurchaseItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("purchaseItem")
public class PurchaseItemController {
    private static PurchaseItemService purchaseItemService;

    public PurchaseItemController(PurchaseItemService purchaseItemS){ this.purchaseItemService = purchaseItemS;}

    @GetMapping("all")
    public List<CreatePurchaseItemDto> showAll(){
        return this.purchaseItemService.showAll();
    }

    @PostMapping("new")
    public CreatePurchaseItemDto newPurchaseItem(@RequestBody CreatePurchaseItemDto purchaseItem){
        return this.purchaseItemService.newPurchaseItem(purchaseItem);
    }

    @DeleteMapping("purchaseItem/{id}")
    public void deleteItem(@PathVariable("id") long id){
        this.purchaseItemService.deletePurchaseItem(id);
    }

    @PutMapping("purchaseItem/{id}")
    public CreatePurchaseItemDto updatePurchaseItem(@PathVariable("id") long id, @RequestBody CreatePurchaseItemDto purchaseItem){
        return this.purchaseItemService.updatePurchaseItem(id, purchaseItem);
    }

}
