package org.receipt.generator.service.rulehandler;

import java.time.LocalTime;
import org.receipt.generator.model.ReceiptRequest;
import org.springframework.stereotype.Component;

@Component("purchaseTimePointsHandler")
public class PurchaseTimePointsHandler extends RuleHandler {
  @Override
  public Integer handleRequest(ReceiptRequest receiptRequest) {
    LocalTime purchaseTime = receiptRequest.getPurchaseTime();
    LocalTime startTime = LocalTime.of(14, 00);
    LocalTime endTime = LocalTime.of(16, 00);
    int points = 0;

    if(purchaseTime.isAfter(startTime) && purchaseTime.isBefore(endTime)) {
      points += 10;
    }

    return points;
  }
}
