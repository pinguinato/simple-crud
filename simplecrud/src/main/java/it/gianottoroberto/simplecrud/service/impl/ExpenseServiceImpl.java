package it.gianottoroberto.simplecrud.service.impl;

import it.gianottoroberto.simplecrud.controller.response.rest.ExpenseResponse;
import it.gianottoroberto.simplecrud.data.entity.ExpenseEntity;
import it.gianottoroberto.simplecrud.data.repository.ExpenseRepository;
import it.gianottoroberto.simplecrud.service.ExpenseService;
import it.gianottoroberto.simplecrud.service.dto.ExpenseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    private static final String CURRENCY_EURO = "€";

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        List<ExpenseEntity> entityList = expenseRepository.findAll();
        List<ExpenseDTO> dtoList = new ArrayList<>();
        entityList.forEach(expenseEntity -> {
            ExpenseDTO dto = new ExpenseDTO();
            dto.setId(expenseEntity.getId());
            dto.setTitle(expenseEntity.getTitle());
            dto.setDescription(expenseEntity.getDescription());
            dto.setExpenseDate(expenseEntity.getExpenseDate());
            dto.setLastUpdateTimestamp(expenseEntity.getLastUpdateTimestamp());
            dto.setAmount(expenseEntity.getAmount());
            dtoList.add(dto);
        });

        return dtoList;
    }

    @Override
    public List<ExpenseResponse> composeExpensesResponse(List<ExpenseDTO> inputList) {
        List<ExpenseResponse> resultList = new ArrayList<>();
        inputList.forEach(expenseDTO -> {
            ExpenseResponse expenseResponse = new ExpenseResponse();
            expenseResponse.setCurrency(CURRENCY_EURO);
            expenseResponse.setDescription(expenseDTO.getDescription());
            expenseResponse.setTitle(expenseDTO.getTitle());
            expenseResponse.setId(expenseDTO.getId());
            expenseResponse.setAmount(expenseDTO.getAmount());
            resultList.add(expenseResponse);
        });

        return resultList;
    }


}
