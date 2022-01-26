package com.trilhajava.trilhajava.dto;

import com.trilhajava.trilhajava.entity.CategoryEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class CategoryDTO {

    private String name;

    private String description;

    public static CategoryEntity mapToEntity(CategoryDTO dto) {
        return CategoryEntity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}
