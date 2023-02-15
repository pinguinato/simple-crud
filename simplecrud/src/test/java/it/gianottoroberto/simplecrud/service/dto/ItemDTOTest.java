package it.gianottoroberto.simplecrud.service.dto;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ItemDTOTest {

    @Test
    void getterAndSetterTest(){
         ItemDTO itemDTO = new ItemDTO();
         itemDTO.setItemName("item name");
         itemDTO.setItemId(1);
         itemDTO.setAddedOn(LocalDateTime.now());
         itemDTO.setDescription("item description");

         System.out.println(itemDTO);

         assertNotNull(itemDTO);
    }


}
