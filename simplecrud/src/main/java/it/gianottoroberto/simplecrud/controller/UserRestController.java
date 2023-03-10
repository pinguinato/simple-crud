package it.gianottoroberto.simplecrud.controller;


import it.gianottoroberto.simplecrud.controller.request.rest.CreateUserRequest;
import it.gianottoroberto.simplecrud.exception.UserBadRequestException;
import it.gianottoroberto.simplecrud.exception.UserNotFoundException;
import it.gianottoroberto.simplecrud.service.UserService;
import it.gianottoroberto.simplecrud.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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
    public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Integer userId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @GetMapping(value = "user/search/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getUserByUserName(@PathVariable("userName") String userName) {
        return new ResponseEntity<>(userService.getUserByUserName(userName), HttpStatus.OK);
    }

    @PostMapping(
            value = "/user",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> createUser(
            @RequestBody @Valid CreateUserRequest createUserRequest
    ) throws UserBadRequestException {
        return new ResponseEntity<>(
                userService.createUser(createUserRequest.getName(), createUserRequest.getEmail()),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(value = "/user/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") Integer userId) throws Exception {
        userService.deleteUserById(userId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
