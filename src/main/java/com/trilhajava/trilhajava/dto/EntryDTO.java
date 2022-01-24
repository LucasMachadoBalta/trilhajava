package com.trilhajava.trilhajava.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class EntryDTO {

    private String name;
    private String description;
    private String type;
    private String amount;
    private String date;
    private Boolean paid;
}
