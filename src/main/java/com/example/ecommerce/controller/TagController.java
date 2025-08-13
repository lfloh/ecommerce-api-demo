package com.example.ecommerce.controller;

import com.example.ecommerce.model.Tag;
import com.example.ecommerce.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public Tag addTag(@RequestBody Tag tag) {
        return tagService.create(tag);
    }

    @GetMapping
    public List<Tag> getTagList() {
        return tagService.getAll();
    }


}

