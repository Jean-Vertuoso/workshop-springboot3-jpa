package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import com.educandoweb.course.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> result = repository.findAll();

        return result.stream().map(CategoryDTO::new).toList();
    }
}