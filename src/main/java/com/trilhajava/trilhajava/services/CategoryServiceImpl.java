package com.trilhajava.trilhajava.services;

import com.trilhajava.trilhajava.dto.CategoryDTO;
import com.trilhajava.trilhajava.dto.EntryDTO;
import com.trilhajava.trilhajava.entity.CategoryEntity;
import com.trilhajava.trilhajava.entity.EntryEntity;
import com.trilhajava.trilhajava.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Object findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public List<Object> findAll() {
        return new ArrayList<>(categoryRepository.findAll());
    }

    public CategoryDTO save(CategoryDTO dto) {

        //return categoryRepository.save(dto);
        return mapToDTO(categoryRepository.save(mapToEntity((CategoryDTO) dto)));
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public CategoryEntity put(CategoryDTO dto) {
        return categoryRepository.save(mapToEntity(dto));
    }

    private CategoryEntity mapToEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryEntity.class);
    }

    private CategoryDTO mapToDTO(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryDTO.class);
    }
}
