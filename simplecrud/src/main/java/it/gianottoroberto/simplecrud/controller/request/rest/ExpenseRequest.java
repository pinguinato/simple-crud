package it.gianottoroberto.simplecrud.controller.request.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequest {

    @NotNull(message = "title is mandatory")
    @NotEmpty(message = "title is empty")
    private String title;

    private String description;

    @NotNull(message = "Amount is mandatory")
    @NotEmpty(message = "Amount is empty")
    private Double amount;
}
