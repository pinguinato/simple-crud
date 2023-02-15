package it.gianottoroberto.simplecrud.service.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {
    @NotNull(message = "Name is mandatory")
    @NotEmpty(message = "Name is empty")
    private String name;
    @NotNull(message = "Email is mandatory")
    @NotEmpty(message = "Email is empty")
    private String email;
}
