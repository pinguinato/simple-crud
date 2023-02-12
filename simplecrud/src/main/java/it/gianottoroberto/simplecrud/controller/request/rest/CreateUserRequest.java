package it.gianottoroberto.simplecrud.controller.request.rest;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateUserRequest {
    @NotNull(message = "name is mandatory")
    @NotEmpty(message = "name is empty")
    private String name;

    @NotNull(message = "email is mandatory")
    @NotEmpty(message = "email is empty")
    private String email;
}
