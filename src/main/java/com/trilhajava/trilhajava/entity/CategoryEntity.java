package com.trilhajava.trilhajava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trilhajava.trilhajava.dto.CategoryDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CATEGORY")
@NoArgsConstructor
@AllArgsConstructor
@Data // anotação necessária?
@Builder // anotação necessária?
public class CategoryEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "categoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<EntryEntity> listEntries;

    public static CategoryDTO mapToDTO(CategoryEntity categoryEntity) {
        return CategoryDTO.builder()
                .description(categoryEntity.description)
                .name(categoryEntity.name)
                .build();
    }

    /*
    private CategoryEntity mapToDTO(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryEntity.class);

    }
    //@Autowired
    //private ModelMapper modelMapper;
     */

}
