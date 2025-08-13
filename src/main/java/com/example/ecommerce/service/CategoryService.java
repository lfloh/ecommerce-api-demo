package com.example.ecommerce.service;

import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    //Create
    @PostMapping
    public Category create(Category category){
        return categoryRepository.save(category);
    }

    // get all categry
    @GetMapping
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }




    // Read by Category Id
    @GetMapping("/{cid}")
    public Category getCategory(@PathVariable long cid){
        return categoryRepository.findById(cid).orElseThrow(()-> new RuntimeException("Category not found"));
        //          .orElseThrow(() -> new RuntimeException("Product not found"));
    }


}
