package com.trilhajava.trilhajava.services;

import com.trilhajava.trilhajava.dto.CategoryDTO;
import com.trilhajava.trilhajava.dto.EntryDTO;
import com.trilhajava.trilhajava.entity.CategoryEntity;
import com.trilhajava.trilhajava.entity.EntryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    CategoryEntity findById(Long id);

    List<CategoryEntity> findAll();

    CategoryDTO save(CategoryDTO dto);

    CategoryEntity put(CategoryDTO dto);

    void updateById(Long id, CategoryDTO dto); // ñ seria melhor return obj p/ mostrar alterações?

    void delete(Long id);
}
