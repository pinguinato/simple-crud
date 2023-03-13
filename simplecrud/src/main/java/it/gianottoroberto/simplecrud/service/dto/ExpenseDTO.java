package it.gianottoroberto.simplecrud.service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ExpenseDTO {
    private Integer id;
    private String title;
    private String description;
    private Double amount;
    private LocalDateTime lastUpdateTimestamp;
    private LocalDate expenseDate;

    private AuthorDTO expenseAuthor;
}
