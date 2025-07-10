package com.sorushi.docker_kubernetes.service;

import com.sorushi.docker_kubernetes.dto.ExpenseDTO;
import com.sorushi.docker_kubernetes.entity.Expense;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {
  Expense addExpense(ExpenseDTO dto);
  List<Expense> getAllExpenses();
  List<Expense> getExpensesByCategory(String category);
  List<Expense> getExpensesBetweenDates(LocalDate from, LocalDate to);
  void deleteExpense(Long id);
}
