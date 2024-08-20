package org.receipt.generator.service.rulehandler;

import lombok.NoArgsConstructor;
import org.receipt.generator.model.ReceiptRequest;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public abstract class RuleHandler {

  protected RuleHandler handler;

  public abstract Integer handleRequest(ReceiptRequest receiptRequest);

  public void setNextHandler(RuleHandler ruleHandler) {
    this.handler = ruleHandler;
  }
}
