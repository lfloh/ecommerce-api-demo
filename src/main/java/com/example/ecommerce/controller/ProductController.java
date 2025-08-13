package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product, @RequestParam Long categoryID, @RequestParam List<Long> tagIds){
        // Create a new product which come with category ID - DTO
        // Best practice is to use DTO
        // using requestparam -> localhost:8080/api/products?categoryID=1
        return productService.createProduct(product,categoryID,tagIds);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }



}
