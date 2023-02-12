package it.gianottoroberto.simplecrud.data.repository;

import it.gianottoroberto.simplecrud.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    List<UserEntity> findAllByName(String name);

}
