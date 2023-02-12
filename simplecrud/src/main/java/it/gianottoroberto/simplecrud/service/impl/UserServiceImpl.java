package it.gianottoroberto.simplecrud.service.impl;

import it.gianottoroberto.simplecrud.data.entity.UserEntity;
import it.gianottoroberto.simplecrud.data.repository.UserRepository;
import it.gianottoroberto.simplecrud.service.UserService;
import it.gianottoroberto.simplecrud.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addNewUser(UserDTO userDTO) {
        UserEntity newUser = new UserEntity();
        newUser.setName(userDTO.getName());
        newUser.setEmail(userDTO.getEmail());
        userRepository.save(newUser);
    }

}
