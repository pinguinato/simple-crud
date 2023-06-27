package it.gianottoroberto.simplecrud.controller.response.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseResponse {
    private Integer id;
    private String title;
    private String description;
    private Double amount;
    private String currency;

}
