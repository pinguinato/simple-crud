package it.gianottoroberto.simplecrud.controller;

import it.gianottoroberto.simplecrud.controller.request.rest.ExpenseRequest;
import it.gianottoroberto.simplecrud.controller.response.rest.ExpenseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/expense-controller")
@Slf4j
public class ExpenseRestController {

    private static final String CURRENCY_EURO = "€";

    @GetMapping(value = "/expenses/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ExpenseResponse>> getAllExpenses() {

        List<ExpenseResponse> list = new ArrayList<>();

        ExpenseResponse test = new ExpenseResponse();
        test.setId(111);
        test.setTitle("Acquisto scarpe nuove");
        test.setDescription("Acquisto nuove scarpe della marca Salomon per me.");
        test.setAmount(178.50);
        test.setCurrency(CURRENCY_EURO);

        ExpenseResponse test2 = new ExpenseResponse();
        test2.setId(112);
        test2.setTitle("Bonifico per Stefania");
        test2.setDescription("Bonifico a Stefania per il pagamento dell'affitto del mese di aprile");
        test2.setAmount(306.15);
        test2.setCurrency(CURRENCY_EURO);

        list.add(test);
        list.add(test2);

        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping(value = "/expenses/{expenseId}/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExpenseResponse> getExpense(
            @PathVariable(value = "expenseId") Integer expenseId
    ) {

        ExpenseResponse test = new ExpenseResponse();
        test.setId(111);
        test.setTitle("Acquisto scarpe nuove");
        test.setDescription("Acquisto nuove scarpe della marca Salomon per me.");
        test.setAmount(178.50);
        test.setCurrency(CURRENCY_EURO);

        return new ResponseEntity<>(test,HttpStatus.OK);
    }

    @PostMapping(value = "/expenses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExpenseResponse> createNewExpense(@RequestBody @Valid ExpenseRequest request) {
        log.info("Enter: createNewExpense with request:[{}]", request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
