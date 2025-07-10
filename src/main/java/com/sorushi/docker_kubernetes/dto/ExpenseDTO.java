package com.sorushi.docker_kubernetes.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseDTO {

  private String description;
  private BigDecimal amount;
  private String category;
  private LocalDate date;
}
