package it.gianottoroberto.simplecrud.service.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class InventoryDTO {
    private Integer itemId;
    private Integer count;
    private LocalDateTime updatedOn;
}
