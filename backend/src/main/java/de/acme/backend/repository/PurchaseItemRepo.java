package de.acme.backend.repository;

import de.acme.backend.domain.PurchaseItem;
import org.springframework.data.repository.ListCrudRepository;

public interface PurchaseItemRepo extends ListCrudRepository<PurchaseItem, Long> {
}
