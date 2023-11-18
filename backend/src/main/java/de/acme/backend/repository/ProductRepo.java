package de.acme.backend.repository;

import de.acme.backend.domain.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends ListCrudRepository<Product, Long> {
}