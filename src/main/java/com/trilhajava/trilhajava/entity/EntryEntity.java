package com.trilhajava.trilhajava.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_ENTRY")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Setter
@Getter
public class EntryEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "entry_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    private String type;
    private String amount;
    private String date;
    private Boolean paid;

    /*
    @ManyToOne
    @JoinColumn(name="category", referencedColumnName = "id")
    private CategoryEntity category;
     */


}
