package com.trilhajava.trilhajava.services;

import com.trilhajava.trilhajava.dto.CategoryDTO;
import com.trilhajava.trilhajava.entity.CategoryEntity;
import com.trilhajava.trilhajava.exceptions.CategoryNotFoundException;
import com.trilhajava.trilhajava.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.trilhajava.trilhajava.dto.CategoryDTO.mapToEntity;

@Service
public class CategoryServiceImpl {

    @Autowired
    private CategoryRepository categoryRepository;

    //@Autowired
    //private ModelMapper modelMapper;

    /*
    public void CategoryService(CategoryRepository repository, ModelMapper modelMapper) {
        this.categoryRepository = repository;
        this.modelMapper = modelMapper;
    }
     */


    public CategoryEntity findById(Long id) {
        Optional<CategoryEntity> opt = categoryRepository.findById(id);
        return opt.orElseThrow(() -> new CategoryNotFoundException(
                "ID: " + id + " não encontrado. " + "Tipo: " + CategoryNotFoundException.class.getName()));

        //return categoryRepository.findById(id).get();
    }

    public List<CategoryEntity> findAll() {
        return new ArrayList<>(categoryRepository.findAll());
    }

    public CategoryEntity save(CategoryDTO dto) {
        //return categoryRepository.save(dto);
        //return mapToDTO(categoryRepository.save(mapToEntity((CategoryDTO) dto)));
        return categoryRepository.save(mapToEntity((CategoryDTO) dto));
    }


    public void delete(Long id) {
        Optional<CategoryEntity> opt = categoryRepository.findById(id);
        try {
            if (opt.isPresent()) {
                categoryRepository.deleteById(id);
            } else {
                throw new CategoryNotFoundException("id não encontrado");
            }
        } catch (CategoryNotFoundException e) {
            e.printStackTrace();
        }

        //categoryRepository.deleteById(id);
    }
    /*

    public CategoryEntity put(CategoryDTO dto) {
        return categoryRepository.save(mapToEntity(dto));
    }

     */


    public CategoryEntity updateById(CategoryDTO dto) {
        CategoryEntity categoryUpdated = categoryRepository.findById(dto.getId())
                .orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada"));
        categoryUpdated.setName(dto.getName());
        categoryUpdated.setDescription(dto.getDescription());
        return categoryRepository.save(categoryUpdated);

        /*
        Optional<CategoryEntity> opt = categoryRepository.findById(id);
        try {
            if (opt.isPresent()) {
                opt.get(dto.setName()); //.setName(dto.getName());
                opt.getDescription(dto.getDescription());
                categoryRepository.save(opt);
            } else {
                throw new CategoryNotFoundException("Categoria não encontrada");
            }
        } catch (CategoryNotFoundException e) {
            e.printStackTrace();
        }
     */

    }



    /*
    private CategoryEntity mapToEntity(CategoryDTO dto) {
        return CategoryEntity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }


    private CategoryEntity mapToEntity(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryEntity.class);
    }

    private CategoryDTO mapToDTO(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryDTO.class);
    }
     */


}
