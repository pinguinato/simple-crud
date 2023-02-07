package it.gianottoroberto.simplecrud.data.repository;

import it.gianottoroberto.simplecrud.data.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
}
