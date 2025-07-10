package com.sorushi.docker_kubernetes.service.serviceImpl;

import com.sorushi.docker_kubernetes.dto.ExpenseDTO;
import com.sorushi.docker_kubernetes.entity.Expense;
import com.sorushi.docker_kubernetes.repository.ExpenseRepository;
import com.sorushi.docker_kubernetes.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

  private final ExpenseRepository repository;

  @Override
  public Expense addExpense(ExpenseDTO dto) {
    Expense expense = Expense.builder()
        .description(dto.getDescription())
        .amount(dto.getAmount())
        .category(dto.getCategory())
        .date(dto.getDate())
        .build();
    return repository.save(expense);
  }

  @Override
  public List<Expense> getAllExpenses() {
    return repository.findAll();
  }

  @Override
  public List<Expense> getExpensesByCategory(String category) {
    return repository.findByCategory(category);
  }

  @Override
  public List<Expense> getExpensesBetweenDates(LocalDate from, LocalDate to) {
    return repository.findByDateBetween(from, to);
  }

  @Override
  public void deleteExpense(Long id) {
    repository.deleteById(id);
  }
}
