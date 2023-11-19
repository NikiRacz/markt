package de.acme.backend.repository;

import de.acme.backend.domain.Costumer;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepo extends ListCrudRepository<Costumer, Long> {
}
