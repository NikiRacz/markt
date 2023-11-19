package de.acme.backend.service;

import de.acme.backend.domain.Product;
import de.acme.backend.dto.CreateProductDto;
import de.acme.backend.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static ProductRepo productRepo;
    public ProductService(ProductRepo productRep){
        this.productRepo = productRep;
    }

    public List<CreateProductDto> getAll(){
        var productDtoList = new ArrayList<CreateProductDto>();
        var productList =  this.productRepo.findAll();
        productList.forEach((productEntity) -> {
            CreateProductDto element = new CreateProductDto();
            productDtoList.add(element.entityToDto(productEntity));
        });
        return productDtoList;
    }

    public CreateProductDto addNew(CreateProductDto product){
        Product newP = product.dtoTopEntity(product);
        Product productEntity = productRepo.save(newP);
        return product.entityToDto(productEntity);
    }

    public void deleteItem(long id){
          productRepo.deleteById(id);
    }

    public CreateProductDto updateItem(long id, CreateProductDto product){
         Optional<Product> productToUpdate = productRepo.findById(id);
         var theProduct = productToUpdate.get();
         if(product.getName() != null) {
             theProduct.setName(product.getName());
         }
         if(product.getSort() != null){
             theProduct.setSort(product.getSort());
         }
         Optional.of(this.productRepo.save(theProduct));
        CreateProductDto productDto = product.entityToDto(theProduct);
        return productDto;
    }
}
