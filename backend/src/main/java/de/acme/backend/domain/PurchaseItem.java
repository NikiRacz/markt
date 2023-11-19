package de.acme.backend.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchaseItem")
@Data
@NoArgsConstructor
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Product product;
    private int amount;
    private int price;
}
