package it.gianottoroberto.simplecrud.controller.request.rest;

import it.gianottoroberto.simplecrud.service.dto.AuthorDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateExpenseRequest {

    @NotNull(message = "title is mandatory")
    @NotEmpty(message = "title is empty")
    private String title;

    private String description;

    @NotNull(message = "Amount is mandatory")
    @NotEmpty(message = "Amount is empty")
    private Double amount;

    @NotNull(message = "Author is mandatory")
    private AuthorDTO author;

}
