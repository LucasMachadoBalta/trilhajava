package com.trilhajava.trilhajava.services;

import com.trilhajava.trilhajava.models.CategoryEntity;
import com.trilhajava.trilhajava.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl {

    @Autowired
    private CategoryRepository categoryRepository;

    //@Autowired
    //private ModelMapper modelMapper;

    public Object findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public List<Object> findAll() {
        return new ArrayList<>(categoryRepository.findAll());
    }

    public CategoryEntity save(CategoryEntity dto) {

        return categoryRepository.save(dto);
        //return categoryRepository.save(mapToDTO((CategoryDTO) dto));
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    /*
    public Object put(Object dto) {
        return categoryRepository.save(mapToDTO((CategoryDTO) dto));
    }

     */
}
