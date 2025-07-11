package com.sorushi.docker_kubernetes.repository;

import com.sorushi.docker_kubernetes.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
  List<Expense> findByCategory(String category);
  List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
