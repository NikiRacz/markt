package de.acme.backend.service;

import de.acme.backend.domain.Purchase;
import de.acme.backend.dto.CreatePurchaseDto;
import de.acme.backend.repository.PurchaseRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    private static PurchaseRepo purchaseRepo;

    public PurchaseService(PurchaseRepo pr){this.purchaseRepo = pr;}

    public List<CreatePurchaseDto> showAllPurchases(){
        var purchaseDtoList = new ArrayList<CreatePurchaseDto>();
        var purchaseList = this.purchaseRepo.findAll();
        purchaseList.forEach((purchaseEntity)->{
            CreatePurchaseDto element = new CreatePurchaseDto();
            purchaseDtoList.add(element.entityToDto(purchaseEntity));
        });
        return purchaseDtoList;
    }

    public CreatePurchaseDto newPurchase(CreatePurchaseDto purchaseDto){
        Purchase purchaseEntity = purchaseDto.dtoToEntity(purchaseDto);
        Purchase purchase = purchaseRepo.save(purchaseEntity);
        return purchaseDto.entityToDto(purchase);
    }

    public void deletePurchase(long id){
        this.purchaseRepo.deleteById(id);
    }

    public CreatePurchaseDto updatePurchase(long id, CreatePurchaseDto purchaseDto){
        Optional<Purchase> purchaseToUpdate = this.purchaseRepo.findById(id);
        Purchase updatedPurchase = purchaseToUpdate.get();
        if(purchaseDto.getCostumer() != null){
            updatedPurchase.setCostumer(purchaseDto.getCostumer());
        }
        if(purchaseDto.getSumPrice() != 0){
            updatedPurchase.setSumPrice(purchaseDto.getSumPrice());
        }
        if(purchaseDto.getDatum() != 0){
            updatedPurchase.setDatum(purchaseDto.getDatum());
        }
        this.purchaseRepo.save(updatedPurchase);
        CreatePurchaseDto purchase = purchaseDto.entityToDto(updatedPurchase);
        return purchase;
    }


}
