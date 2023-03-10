package it.gianottoroberto.simplecrud.service.impl;

import it.gianottoroberto.simplecrud.data.entity.UserEntity;
import it.gianottoroberto.simplecrud.data.repository.UserRepository;
import it.gianottoroberto.simplecrud.exception.UserBadRequestException;
import it.gianottoroberto.simplecrud.exception.UserNotFoundException;
import it.gianottoroberto.simplecrud.service.UserService;
import it.gianottoroberto.simplecrud.service.dto.UserDTO;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
            throw new UserNotFoundException("User id "+userId+" not found.");
        }

        UserDTO dto = new UserDTO();
        dto.setName(optionalUserEntity.get().getName());
        dto.setEmail(optionalUserEntity.get().getEmail());

        return dto;
    }

    @Override
    public List<UserDTO> getUserByUserName(String userName) {
        List<UserEntity> entities = userRepository.findAllByName(userName);

        if (entities.isEmpty()) {
            return new ArrayList<>();
        }

        return composeListOfUsersDtoFromUserEntities(entities);
    }

    @Override
    public UserDTO createUser(String name, String email) throws UserBadRequestException {
        UserDTO result = new UserDTO();
        UserEntity userEntity = new UserEntity();

        if (Objects.nonNull(name) && !name.isEmpty()) {
            result.setName(name);
            userEntity.setName(name);
        } else {
            throw new UserBadRequestException("Name is null or empty");
        }

        if (Objects.nonNull(email) && !email.isEmpty()) {
            result.setEmail(email);
            userEntity.setEmail(email);
        } else {
            throw new UserBadRequestException("Email is null or empty");
        }

        try {
            userRepository.save(userEntity);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return result;
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

    @Override
    public void deleteUserById(Integer userId) throws UserNotFoundException {

        UserEntity userEntity = loadUserById(userId);

        userRepository.deleteById(userEntity.getId());
    }

    private UserEntity loadUserById(Integer userId) throws UserNotFoundException {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);

        if (optionalUserEntity.isEmpty()) {
            throw new UserNotFoundException("User of id: " + userId + " not found.");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setId(optionalUserEntity.get().getId());
        userEntity.setName(optionalUserEntity.get().getName());
        userEntity.setEmail(optionalUserEntity.get().getEmail());

        return userEntity;
    }
}
