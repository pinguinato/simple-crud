package it.gianottoroberto.simplecrud.service.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserDTOTest {

    @Test
    void userDTOTest() {
        UserDTO user = new UserDTO();
        user.setName("name");
        user.setEmail("email");
        assertNotNull(user);
        assertEquals("name", user.getName());
        assertEquals("email", user.getEmail());
        assertEquals(UserDTO.class, user.getClass());
    }

}
