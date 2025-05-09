package org.example.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.billingservice.model.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter
@Setter @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private long customerId;

    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems = new ArrayList<>();

    //Transit: Cet attribut est dans la classe mais n'est pas representé dans la base de donnée
    @Transient private Customer customer;

}
