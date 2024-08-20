package org.receipt.generator.service.rulehandler;

import org.receipt.generator.model.ReceiptRequest;
import org.springframework.stereotype.Component;

@Component("purchaseDatePointsHandler")
public class PurchaseDatePointsHandler extends RuleHandler {

  @Override
  public Integer handleRequest(ReceiptRequest receiptRequest) {
    int points = 0;
    int day = receiptRequest.getPurchaseDate().getDayOfMonth();
    if(day % 2 == 1) {
      points += 6;
    }
    return points;
  }
}
