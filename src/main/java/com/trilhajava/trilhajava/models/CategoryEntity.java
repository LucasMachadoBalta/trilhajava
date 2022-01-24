package com.trilhajava.trilhajava.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_CATEGORY")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryEntity {

    private static final long serialVersionUID = 1L;

    /*
    @Autowired
    private ModelMapper modelMapper;
     */

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

    private CategoryEntity mapToDTO(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryEntity.class);

    }

     */
}
