package it.gianottoroberto.simplecrud.service.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InventoryDTOTest {

    @Test
    void testGetterSetter() {
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setItemId(1111);
        inventoryDTO.setCount(10);
        inventoryDTO.setUpdatedOn(LocalDateTime.now());

        assertNotNull(inventoryDTO);
    }

}
