package org.receipt.generator.service.rulehandler;

import org.receipt.generator.model.ReceiptRequest;
import org.springframework.stereotype.Component;

@Component("numberOfItemsPointsHandler")
public class NumberOfItemsPointsHandler extends RuleHandler {

  @Override
  public Integer handleRequest(ReceiptRequest receiptRequest) {
    int points = 0;
    if(!receiptRequest.getItems().isEmpty()) {
      int totalItems = receiptRequest.getItems().size();
      points += totalItems/2 * 5;
    }
    return points;
  }
}
