package it.gianottoroberto.simplecrud.controller;


import it.gianottoroberto.simplecrud.service.UserService;
import it.gianottoroberto.simplecrud.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user-controller")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(
            @PathVariable("userId") Integer userId
    ) throws Exception {
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

}
