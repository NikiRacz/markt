package de.acme.backend.service;

import de.acme.backend.domain.PurchaseItem;
import de.acme.backend.dto.CreatePurchaseItemDto;
import de.acme.backend.repository.PurchaseItemRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseItemService {
    private static PurchaseItemRepo purchaseItemRepo;

    public PurchaseItemService(PurchaseItemRepo purchaseItemRep) {this.purchaseItemRepo = purchaseItemRep;}

    public List<CreatePurchaseItemDto> showAll(){
        var purchaseItemDtoList = new ArrayList<CreatePurchaseItemDto>();
        var purchaseItemList = this.purchaseItemRepo.findAll();
        purchaseItemList.forEach((purchaseItem)->{
            CreatePurchaseItemDto element = new CreatePurchaseItemDto();
            purchaseItemDtoList.add(element.entityToDto(purchaseItem));
        });
        return purchaseItemDtoList;
    }

    public CreatePurchaseItemDto newPurchaseItem(CreatePurchaseItemDto purchaseItemDto){
        PurchaseItem purchaseItemEntity = purchaseItemDto.dtoToEntity(purchaseItemDto);
        PurchaseItem purchaseItem = purchaseItemRepo.save(purchaseItemEntity);
        return purchaseItemDto.entityToDto(purchaseItem);
    }

    public void deletePurchaseItem(Long id){
        this.purchaseItemRepo.deleteById(id);
    }

    public CreatePurchaseItemDto updatePurchaseItem(long id, CreatePurchaseItemDto purchaseItem){
        Optional<PurchaseItem> purchaseItemToUpdate = this.purchaseItemRepo.findById(id);
        PurchaseItem updated = purchaseItemToUpdate.get();
        if(purchaseItem.getProduct() != null){
            updated.setProduct(purchaseItem.getProduct());
        }
        if(purchaseItem.getPrice() != 0){
            updated.setPrice(purchaseItem.getPrice());
        }
       if(purchaseItem.getAmount() != 0){
           updated.setAmount(purchaseItem.getAmount());
       }
       this.purchaseItemRepo.save(updated);
       CreatePurchaseItemDto purchaseItemDto = purchaseItem.entityToDto(updated);
       return purchaseItemDto;
    }
}
