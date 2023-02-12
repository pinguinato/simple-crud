package it.gianottoroberto.simplecrud.service;

import it.gianottoroberto.simplecrud.exception.UserBadRequestException;
import it.gianottoroberto.simplecrud.exception.UserNotFoundException;
import it.gianottoroberto.simplecrud.service.dto.UserDTO;

import java.util.List;

public interface UserService {

    void addNewUser(UserDTO userDTO);

    /**
     * Listing all users from User table
     * @return a List<UserDTO> list of users
     */
    List<UserDTO> getAllUsers();

    UserDTO getUser(Integer userId) throws UserNotFoundException;

    List<UserDTO> getUserByUserName(String userName);

    UserDTO createUser(String name, String email) throws UserBadRequestException;
}
