package it.gianottoroberto.simplecrud.service.impl;

import it.gianottoroberto.simplecrud.data.entity.UserEntity;
import it.gianottoroberto.simplecrud.data.repository.UserRepository;
import it.gianottoroberto.simplecrud.exception.UserNotFoundException;
import it.gianottoroberto.simplecrud.service.UserService;
import it.gianottoroberto.simplecrud.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> list = userRepository.findAll();

        if (list.isEmpty()) {
            return new ArrayList<>();
        }

        return composeListOfUsersDtoFromUserEntities(list);
    }

    @Override
    public UserDTO getUser(Integer userId) throws UserNotFoundException {

        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);

        if (optionalUserEntity.isEmpty()) {
            throw new UserNotFoundException();
        }

        UserDTO dto = new UserDTO();
        dto.setName(optionalUserEntity.get().getName());
        dto.setEmail(optionalUserEntity.get().getEmail());

        return dto;
    }

    private List<UserDTO> composeListOfUsersDtoFromUserEntities(List<UserEntity> userEntities) {
        List<UserDTO> list = new ArrayList<>();
        for (UserEntity user : userEntities) {
            UserDTO dto = new UserDTO();
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            list.add(dto);
        }

        return list;
    }


}
