package org.receipt.generator.service.rulehandler;

import org.receipt.generator.model.ReceiptRequest;
import org.springframework.stereotype.Component;

@Component("retailerNamePointsHandler")
public class RetailerNamePointsHandler extends RuleHandler {
  @Override
  public Integer handleRequest(ReceiptRequest receiptRequest) {
    int points = 0;
      String retailerName = receiptRequest.getRetailer();
      int count = (int) retailerName.chars().filter(Character::isLetterOrDigit).count();
      points += count;
      return points;
  }
}
