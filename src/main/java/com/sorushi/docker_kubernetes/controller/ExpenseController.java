package com.sorushi.docker_kubernetes.controller;

import com.sorushi.docker_kubernetes.dto.ExpenseDTO;
import com.sorushi.docker_kubernetes.entity.Expense;
import com.sorushi.docker_kubernetes.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
public class ExpenseController {

  private final ExpenseService service;

  @PostMapping
  public Expense add(@RequestBody ExpenseDTO dto) {
    return service.addExpense(dto);
  }

  @GetMapping
  public List<Expense> getAll() {
    return service.getAllExpenses();
  }

  @GetMapping("/category/{category}")
  public List<Expense> getByCategory(@PathVariable String category) {
    return service.getExpensesByCategory(category);
  }

  @GetMapping("/between")
  public List<Expense> getByDateRange(@RequestParam String from, @RequestParam String to) {
    return service.getExpensesBetweenDates(LocalDate.parse(from), LocalDate.parse(to));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.deleteExpense(id);
  }
}
