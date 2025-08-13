package com.example.ecommerce.service;

import com.example.ecommerce.model.Tag;
import com.example.ecommerce.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    //Create
    @PostMapping
    public Tag create(Tag tag){
        return tagRepository.save(tag);
    }

    // get all categry
    @GetMapping
    public List<Tag> getAll(){
        return tagRepository.findAll();
    }




    // Read by Tag Id
    public Collection<? extends Tag> getTag(List<Long> tagid){
        return tagRepository.findAllById(tagid);
        //          .orElseThrow(() -> new RuntimeException("Product not found"));
    }


}
