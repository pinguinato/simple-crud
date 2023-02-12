package it.gianottoroberto.simplecrud.data.repository;

import it.gianottoroberto.simplecrud.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
