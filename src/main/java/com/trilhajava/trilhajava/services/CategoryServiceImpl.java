package com.trilhajava.trilhajava.services;

import com.trilhajava.trilhajava.dto.CategoryDTO;
import com.trilhajava.trilhajava.entity.CategoryEntity;
import com.trilhajava.trilhajava.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryEntity findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity save(CategoryDTO dto) {
        return categoryRepository.save(matoEntity(dto));
    }

    @Override
    public void delete(Long id) {
        Optional<CategoryEntity> opt = categoryRepository.findById(id);
        try{
            if(opt.isEmpty()){
                logger.error("id could not be found");
            }
            ResponseEntity.ok().body(categoryRepository.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void updateById(Long id, CategoryDTO dto){
        CategoryEntity categoryUpadate = categoryRepository.getById(id);
        categoryUpadate.setName(dto.getName());
        categoryUpadate.setDescription(dto.getDescription());
        categoryRepository.save(categoryUpadate);

    }
    private CategoryEntity matoEntity(CategoryDTO categoryDTO){
        return modelMapper.map(categoryDTO, CategoryEntity.class );
    }

}
