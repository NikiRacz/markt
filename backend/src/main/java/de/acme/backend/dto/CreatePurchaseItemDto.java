package de.acme.backend.dto;

import de.acme.backend.domain.Product;
import de.acme.backend.domain.PurchaseItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatePurchaseItemDto {
    private Product product;
    private int amount;
    private int price;

    public PurchaseItem dtoToEntity(CreatePurchaseItemDto purchaseItemDto){
        var purchaseItem = new PurchaseItem();
        purchaseItem.setProduct(purchaseItemDto.getProduct());
        purchaseItem.setPrice(purchaseItemDto.getPrice());
        purchaseItem.setAmount(purchaseItemDto.getAmount());
        return purchaseItem;

    }

    public CreatePurchaseItemDto entityToDto(PurchaseItem purchaseItem){
        var purchaseItemDto = new CreatePurchaseItemDto();
        purchaseItemDto.setProduct(purchaseItem.getProduct());
        purchaseItemDto.setPrice(purchaseItem.getPrice());
        purchaseItemDto.setAmount(purchaseItem.getAmount());
        return purchaseItemDto;
    }
}
