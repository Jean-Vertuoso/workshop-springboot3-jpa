package com.educandoweb.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.educandoweb.course.dto.ProductDTO;
import com.educandoweb.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    private ProductService service;
    
//    @GetMapping
//    public String teste(){
//        Optional<Product> result = repository.findById(1L);
//        return result.get().getName();
//    }
    
//    @GetMapping
//    public ResponseEntity<List<Product>> findAll(){
//        List<Product> list = service.findAll();
//        return ResponseEntity.ok().body(list);
//    }
    
    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){
        return service.findById(id);
    }
    
}