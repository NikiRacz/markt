package de.acme.backend.controller;

import de.acme.backend.domain.Product;
import de.acme.backend.dto.CreateProductDto;
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
    public List<CreateProductDto> showAll (){
        return this.productService.getAll();
    }

    @PostMapping("new")
    public CreateProductDto addNew(@RequestBody CreateProductDto product){
        return this.productService.addNew(product);
    }

    @DeleteMapping("product/{id}")
    public void deleteProduct(@PathVariable("id") long id){
         this.productService.deleteItem(id);
    }

    @PutMapping("product/{id}")
    public CreateProductDto updateProduct(@PathVariable("id") long id, @RequestBody CreateProductDto product){
        return this.productService.updateItem(id, product);
    }

}
