package com.trilhajava.trilhajava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trilhajava.trilhajava.dto.CategoryDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
    //@NotNull
    private String name;

    @Column(name = "description")
    //@NotNull
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<EntryEntity> listEntries;

    public static CategoryDTO mapToDTO(CategoryEntity categoryEntity) {
        return CategoryDTO.builder()
                .description(categoryEntity.description)
                .name(categoryEntity.name)
                .build();
    }

    public CategoryEntity  (String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    /*
    private CategoryEntity mapToDTO(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryEntity.class);

    }
    //@Autowired
    //private ModelMapper modelMapper;
     */

}
