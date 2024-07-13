package com.educandoweb.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educandoweb.course.dto.ProductDTO;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;
    
    //Trás uma lista paginada dos produtos
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }
    
    //Trás um produto específico pelo seu ID
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).get();        
        return new ProductDTO(product);
    }
    
    //Recebendo DTO do produto cadastrado pelo frontend, salvando no banco de dados, e retornando a entidade produto convertido em DTO
    @Transactional()
    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();        
        copyDtoToEntity(dto, entity);        
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }
    
    @Transactional()
    public ProductDTO update(Long id,ProductDTO dto){
        Product entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }
    
    //Trás um produto específico pelo seu ID
    @Transactional()
    public void delete(Long id){
        repository.deleteById(id);
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {                
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }
}