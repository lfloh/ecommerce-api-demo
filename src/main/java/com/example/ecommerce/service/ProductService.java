package com.example.ecommerce.service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;

    // Create
    // Add a parameter category id so that i can retrieve the category
    @PostMapping
    public Product createProduct(Product product, Long categoryId, List<Long> tagIds)
    {
        // when i create a new product, i will get the category from categoryId
        // and set it to the product
        product.setCategory(categoryService.getCategory(categoryId));
        product.setTags(Set.copyOf(tagService.getTag(tagIds)));


        return productRepository.save(product);
    }

    // Read
    @GetMapping
    public  List<Product> getAllProduct(){
        return productRepository.findAll();
    }


    // Read by Id
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id){
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
      //          .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Update

    // Delete

}
