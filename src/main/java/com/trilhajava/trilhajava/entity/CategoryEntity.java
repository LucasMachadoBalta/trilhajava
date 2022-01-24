package com.trilhajava.trilhajava.entity;

import com.trilhajava.trilhajava.dto.CategoryDTO;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "TB_CATEGORY")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Setter
@Getter
public class CategoryEntity {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ModelMapper modelMapper;

    @Id
    @Column(name = "categoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    /*
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<EntryEntity> listEntries;
     */

    private CategoryEntity mapToDTO(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryEntity.class);

    }

}
