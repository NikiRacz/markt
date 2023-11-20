package de.acme.backend.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "costumer")
@Data
@NoArgsConstructor
public class Costumer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany()
    @JoinColumn(name = "purchase_Id", referencedColumnName = "id")
    private Set<Purchase> purchase;
}
