package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "carts")
public class Cart {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "cart_id", unique = true)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "carts_products",
            joinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "cart_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")}
    )
    private List<Product> products = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
