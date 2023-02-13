package it.gianottoroberto.simplecrud.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Utils {

    public Utils() {
        // empty constructor
    }

    public static InventoryDTO makeInventoryDTO() {
        InventoryDTO mocked = new InventoryDTO();
        mocked.setCount(10);
        mocked.setUpdatedOn(LocalDateTime.now());
        mocked.setItemId(1);

        return mocked;
    }

    public static ItemDTO makeItemDTO() {
        ItemDTO mocked = new ItemDTO();
        mocked.setItemId(1);
        mocked.setItemName("item test");
        mocked.setDescription("item description");
        mocked.setAddedOn(LocalDateTime.now());

        return mocked;
    }

    public static UserDTO makeUserDTO() {
        UserDTO mocked = new UserDTO();
        mocked.setEmail("testemail@test.com");
        mocked.setName("TestName TestSurname");

        return mocked;
    }
}
