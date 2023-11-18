package de.acme.backend.controller;

import de.acme.backend.domain.Product;
import de.acme.backend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {
    private static ProductService productService;

    public ProductController(ProductService ps){ this.productService = ps; }
    @GetMapping("all")
    public List<Product> showAll (){
        return this.productService.getAll();
    }

    @PostMapping("new")
    public Product addNew(@RequestBody Product product){
        return this.productService.addNew(product);
    }

    @DeleteMapping("product/{id}")
    public void deleteProduct(@PathVariable("id") long id){
         this.productService.deleteItem(id);
    }

    @PutMapping("product/{id}")
    public Optional<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product){
        return this.productService.updateItem(id, product);
    }

}
