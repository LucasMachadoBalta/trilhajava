package com.trilhajava.trilhajava.dto;

import com.trilhajava.trilhajava.entity.CategoryEntity;
import com.trilhajava.trilhajava.entity.EntryEntity;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class CategoryDTO {

    private Long id;

    private String name;

    private String description;

    private List<EntryEntity> listEntries;

    public static CategoryEntity mapToEntity(CategoryDTO dto) {
        return CategoryEntity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }

    public CategoryDTO  (String name, String description) {
        this.name = name;
        this.description = description;
    }
}
