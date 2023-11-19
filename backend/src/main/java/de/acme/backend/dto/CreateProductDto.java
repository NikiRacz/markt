package de.acme.backend.dto;

import de.acme.backend.domain.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateProductDto {
    private String name;
    private String sort;

    public Product dtoTopEntity(CreateProductDto productDto) {
        var product = new Product();
        product.setSort(productDto.getSort());
        product.setName((productDto.getName()));
        return product;
    }

    public CreateProductDto entityToDto(Product product){
        var productDto = new CreateProductDto();
        productDto.setName(product.getName());
        productDto.setSort(product.getSort());
        return productDto;
    }
}
