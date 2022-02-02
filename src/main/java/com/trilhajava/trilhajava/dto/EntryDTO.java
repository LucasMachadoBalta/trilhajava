package com.trilhajava.trilhajava.dto;

import com.trilhajava.trilhajava.entity.CategoryEntity;
import com.trilhajava.trilhajava.entity.EntryEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class EntryDTO {

    private Long id;
    private String name;
    private String description;
    private String type;
    private Integer amount;
    private String date;
    private Boolean paid;
    private CategoryEntity category;

    public static EntryEntity mapToEntity(EntryDTO dto) {
        return EntryEntity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .type(dto.getType())
                .amount(dto.getAmount())
                .date(dto.getDate())
                .paid(dto.getPaid())
                .category(dto.getCategory())
                .build();
    }
}
