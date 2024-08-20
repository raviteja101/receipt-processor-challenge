package org.receipt.generator.util;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RulesUtil {

  private final RulesConfig chain;
  public List<String> getRulesOperations(String productType) {

    return chain.getChain().get(productType.toLowerCase());
  }

}
