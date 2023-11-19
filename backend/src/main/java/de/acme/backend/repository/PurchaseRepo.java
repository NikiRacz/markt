package de.acme.backend.repository;

import de.acme.backend.domain.Purchase;
import org.springframework.data.repository.ListCrudRepository;

public interface PurchaseRepo extends ListCrudRepository<Purchase, Long> {
}
