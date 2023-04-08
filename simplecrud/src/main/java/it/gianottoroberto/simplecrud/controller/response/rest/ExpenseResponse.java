package it.gianottoroberto.simplecrud.controller.response.rest;

import lombok.Data;

@Data
public class ExpenseResponse {
    private Integer id;
    private String title;
    private String description;
    private Double amount;
    private String currency;

}
