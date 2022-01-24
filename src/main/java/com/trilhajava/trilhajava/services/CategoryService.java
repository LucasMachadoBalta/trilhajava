package com.trilhajava.trilhajava.services;

import com.trilhajava.trilhajava.dto.CategoryDTO;
import com.trilhajava.trilhajava.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    CategoryEntity findById(Long id);
    List<CategoryEntity> findAll();
    CategoryEntity save(CategoryDTO dto);
    void delete(Long id);
    void updateById(Long id, CategoryDTO dto);
}
