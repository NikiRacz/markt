package de.acme.backend.repository;

import de.acme.backend.domain.Product;
import de.acme.backend.dto.CreateProductDto;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends ListCrudRepository<Product, Long> {
}