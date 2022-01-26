/*
package com.trilhajava.trilhajava.mappers;

import com.trilhajava.trilhajava.dto.CategoryDTO;
import com.trilhajava.trilhajava.entity.CategoryEntity;

public class CategoryMapper {

    public CategoryDTO mapToDTO(CategoryEntity categoryEntity) {
        return CategoryDTO.builder()
                .description(categoryEntity.description)
                .name(categoryEntity.name)
                .build();
    }

    public CategoryEntity mapToEntity(CategoryDTO dto) {
        return CategoryEntity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}
 */