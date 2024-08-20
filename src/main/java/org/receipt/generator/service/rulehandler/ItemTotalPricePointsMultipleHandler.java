package org.receipt.generator.service.rulehandler;

import org.receipt.generator.model.ReceiptRequest;
import org.springframework.stereotype.Component;

@Component("itemTotalPricePointsMultipleHandler")
public class ItemTotalPricePointsMultipleHandler extends RuleHandler {

  @Override
  public Integer handleRequest(ReceiptRequest receiptRequest) {
    double price = receiptRequest.getTotal();
    int points = 0;
    if(price % 0.25 == 0) {
      points += 25;
    }

    return points;
  }
}
