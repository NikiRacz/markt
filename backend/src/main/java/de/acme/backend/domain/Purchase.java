package de.acme.backend.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "purchase")
@Data
@NoArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private int sumPrice;
    private int datum;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Costumer costumer;

    @ManyToMany()
    @JoinTable(name = "purchaseItem_purchase",
    joinColumns = {@JoinColumn(name = "fk_purchase")},
    inverseJoinColumns = {@JoinColumn(name = "fk_purchase_item")})
    private Set<PurchaseItem> purchaseItemSet;
}