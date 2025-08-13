package com.example.ecommerce.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

//Entity - The Java Class/Bean that will be mapped to the DB using ORM
// ORM - Object Relational Mapping
// Object - ( class,property,methods)
// relational - (table/query/column)
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrement and Unique
    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;
    private String description;
    private double price;
    private int quantity;

    //Getter Setter

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="category_id") // Foreign key
   @JsonBackReference //TBC for tomorrow
    private Category category;

    @ManyToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    // Defining many to many relation
    // There will be additional table created , which is called product_tag
    // inside product_tag, there will be two column , product ID and tag ID , pivot table

    @JoinTable(
            name = "product_tag",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
//    @JsonBackReference //TBC for tomorrow
    private Set<Tag> tags;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}

