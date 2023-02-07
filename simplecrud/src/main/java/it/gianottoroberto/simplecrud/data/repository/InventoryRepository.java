package it.gianottoroberto.simplecrud.data.repository;

import it.gianottoroberto.simplecrud.data.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {
}
