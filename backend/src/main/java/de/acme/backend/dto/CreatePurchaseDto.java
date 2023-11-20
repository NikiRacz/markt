package de.acme.backend.dto;

import de.acme.backend.domain.Costumer;
import de.acme.backend.domain.Purchase;
import de.acme.backend.domain.PurchaseItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatePurchaseDto {
    private Costumer costumer;
    private PurchaseItem purchaseItem;
    private int sumPrice;
    private int datum;

    public Purchase dtoToEntity(CreatePurchaseDto purchaseDto){
        var purchase = new Purchase();
        purchase.setCostumer(purchaseDto.getCostumer());
        purchase.setSumPrice(purchaseDto.getSumPrice());
        purchase.setDatum(purchaseDto.getDatum());
        return purchase;
    }

    public CreatePurchaseDto entityToDto(Purchase purchase){
        var purchaseDto = new CreatePurchaseDto();
        purchaseDto.setCostumer(purchase.getCostumer());
        purchaseDto.setSumPrice(purchase.getSumPrice());
        purchaseDto.setDatum(purchase.getDatum());
        return purchaseDto;
    }
}
