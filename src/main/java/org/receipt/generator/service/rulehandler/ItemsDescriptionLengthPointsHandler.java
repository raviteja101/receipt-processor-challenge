package org.receipt.generator.service.rulehandler;

import org.receipt.generator.model.ReceiptItem;
import org.receipt.generator.model.ReceiptRequest;
import org.springframework.stereotype.Component;

@Component("itemsDescriptionLengthPointsHandler")
public class ItemsDescriptionLengthPointsHandler extends RuleHandler {

  @Override
  public Integer handleRequest(ReceiptRequest receiptRequest) {

    int points = 0;
    for (ReceiptItem item : receiptRequest.getItems()) {
      String itemName = item.getShortDescription().trim();
      if (itemName.length() % 3 == 0) {
        points += (int) Math.ceil(item.getPrice() * 0.2);
      }
    }
    return points;
  }
}
