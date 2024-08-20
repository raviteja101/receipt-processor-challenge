package org.receipt.generator.service.rulehandler;

import org.receipt.generator.model.ReceiptRequest;
import org.springframework.stereotype.Component;


@Component("itemsPricePointsHandler")
public class ItemsPricePointsHandler extends RuleHandler {

  @Override
  public Integer handleRequest(ReceiptRequest receiptRequest) {
      double price = receiptRequest.getTotal();
      int points = 0;
      if(price % 1 == 0) {
        points += 50;
      }
      return points;
  }
}
