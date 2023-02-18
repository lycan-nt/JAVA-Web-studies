package com.owl.mongodb.service;

import com.owl.mongodb.model.Expense;
import com.owl.mongodb.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public void addExpense(Expense expense) {
        this.expenseRepository.insert(expense);
    }

    public List<Expense> getAllExpense() {
        return this.expenseRepository.findAll();
    }

    public void updateExpense(Expense expense) {
        Expense savedExpense = this.expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", expense.getId())));
        this.expenseRepository.save(expense);
    }

    public Expense getExpenseByName(String name) {
        return this.expenseRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by Name %s", name)));
    }

    public void deleteExpense(String id) {
        this.expenseRepository.deleteById(id);
    }

}
