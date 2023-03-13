package it.gianottoroberto.simplecrud.service.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExpenseDTOTest {

    @Test
    void expenseDTOTest_Ok() {
        // expense author definition
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setFirstName("John");
        authorDTO.setLastName("Doe");
        // expense definition
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setExpenseAuthor(authorDTO);
        expenseDTO.setId(111);
        expenseDTO.setExpenseDate(LocalDate.now());
        expenseDTO.setLastUpdateTimestamp(LocalDateTime.now());
        expenseDTO.setTitle("Pay for Pizza");
        expenseDTO.setDescription("Dinner at the ITG Friday's");
        expenseDTO.setAmount(15.00);
        System.out.println("Expense details: [" + expenseDTO + "]");
        assertNotNull(expenseDTO);

    }

}
