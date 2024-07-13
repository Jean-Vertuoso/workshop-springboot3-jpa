package com.educandoweb.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.educandoweb.course.dto.ProductDTO;
import com.educandoweb.course.services.ProductService;
import java.net.URI;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    private ProductService service;
    
    // Recebe a busca paginada do frontend de todos os produtos
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable){
        Page<ProductDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }
    
    // Recebe o id do frontend e envia pro service fazer o read/retrieve no banco de dados pelo id
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id){
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }
    
    //Recebe o formulário preenchido no frontend, instancia em um ProductDTO e envia para o service realizar o create no banco de dados
    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){        
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}