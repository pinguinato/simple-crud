package it.gianottoroberto.simplecrud.service;

import it.gianottoroberto.simplecrud.controller.response.rest.ExpenseResponse;
import it.gianottoroberto.simplecrud.service.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {

    List<ExpenseDTO> getAllExpenses();

    List<ExpenseResponse> composeExpensesResponse(List<ExpenseDTO> inputList);
}
