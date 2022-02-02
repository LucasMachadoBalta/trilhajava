package com.trilhajava.trilhajava.entity;

import com.trilhajava.trilhajava.dto.EntryDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_ENTRY")
@NoArgsConstructor
@AllArgsConstructor
@Data // anotação necessária?
@Builder // anotação necessária?
@Setter
@Getter
public class EntryEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "entry_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "date")
    private String date;

    @Column(name = "paid")
    private Boolean paid;

    @ManyToOne //required = true // caso necessário
    @JoinColumn(name="category", referencedColumnName = "categoryId")
    private CategoryEntity category;

    public static EntryDTO mapToDTO(EntryEntity entryEntity) {
        return EntryDTO.builder()
                .id(entryEntity.id)
                .description(entryEntity.description)
                .name(entryEntity.name)
                .type(entryEntity.type)
                .amount(entryEntity.amount)
                .date(entryEntity.date)
                .paid(entryEntity.paid)
                .category(entryEntity.category)
                .build();
    }

}
