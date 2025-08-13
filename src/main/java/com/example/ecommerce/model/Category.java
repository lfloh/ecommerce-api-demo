package com.example.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade=CascadeType.ALL,fetch = LAZY)
            //To define that this is One to Many relation
            // the relation name is "category" - from child's perspective
            // Cascade - depend on type, will determine how close the relationship in
            // Fetch - Lazy (loosely couple) - less performance impact
            //      - Eager - fetch is always connected (tight coupling example extension file?)
    @JsonManagedReference //tbc
    List<Product> product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
