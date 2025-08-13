package com.example.ecommerce.repository;

//

import com.example.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{
  // this respository will get all the function from JpaRepository
  // The first argument inside <Entity Name : Data Type of ID (@ID)>
//        The theory term is Generic

    // It knows I want to open up "SELECT * FROM PRODUCTS WHERE NAME LIKE '<input name>'
    List<Product> findByName(String name);

    // Select * from Products where price <= <input price>
    List<Product> findByPriceLessThanEqual(double price);

}
