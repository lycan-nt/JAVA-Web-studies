package com.owl.mongodb.controller;

import com.owl.mongodb.model.Expense;
import com.owl.mongodb.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense) {
        this.expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpense() {
        return ResponseEntity.ok(this.expenseService.getAllExpense());
    }

    @PutMapping
    public ResponseEntity updateExpense(@RequestBody Expense expense) {
        this.expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
        return ResponseEntity.ok(this.expenseService.getExpenseByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id) {
        this.expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
