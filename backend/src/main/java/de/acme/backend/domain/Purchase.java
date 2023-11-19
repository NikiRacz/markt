package de.acme.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchase")
@Data
@NoArgsConstructor
public class Purchase {
    private Costumer costumer;
    private PurchaseItem purchaseItem;
    private int sumPrice;
    private int datum;
}
