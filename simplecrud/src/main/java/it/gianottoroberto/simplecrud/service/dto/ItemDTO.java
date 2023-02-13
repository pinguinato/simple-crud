package it.gianottoroberto.simplecrud.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemDTO {
    private Integer itemId;
    private String itemName;
    private String description;
    private LocalDateTime addedOn;
}
