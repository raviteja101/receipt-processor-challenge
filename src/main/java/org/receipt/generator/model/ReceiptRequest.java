package org.receipt.generator.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReceiptRequest {

  private String retailer;
  private LocalDate purchaseDate;
  private LocalTime purchaseTime;
  private double total;
  private List<ReceiptItem> items;
}
