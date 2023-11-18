package de.acme.backend.service;

import de.acme.backend.domain.Product;
import de.acme.backend.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static ProductRepo productRepo;
    public ProductService(ProductRepo productRep){
        this.productRepo = productRep;
    }

    public List<Product> getAll(){return this.productRepo.findAll(); }

    public Product addNew(Product product){
        return productRepo.save(product);
    }

    public void deleteItem(long id){
          productRepo.deleteById(id);
    }

    public Optional<Product> updateItem(long id, Product product){
         Optional<Product> productToUpdate = productRepo.findById(id);
         var theProduct = productToUpdate.get();
         if(product.getName() != null) {
             theProduct.setName(product.getName());
         }
         if(product.getSort() != null){
             theProduct.setSort(product.getSort());
         }
         return Optional.of(this.productRepo.save(theProduct));

    }
}
