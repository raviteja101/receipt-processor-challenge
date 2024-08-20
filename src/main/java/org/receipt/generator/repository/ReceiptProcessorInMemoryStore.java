package org.receipt.generator.repository;


import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.receipt.generator.model.ReceiptRequest;
import org.springframework.stereotype.Service;

@Service
public class ReceiptProcessorInMemoryStore {

  Map<UUID, ReceiptRequest> receiptStoreMap;

  @PostConstruct
  void init() {
    receiptStoreMap = new HashMap<>();
  }

  public ReceiptRequest getReceiptDetails(UUID id) {
    if(receiptStoreMap.containsKey(id)) {
      return receiptStoreMap.get(id);
    }
    return null;
  }

  public void putReceiptDetails(UUID id, ReceiptRequest receiptRequest) {
    receiptStoreMap.put(id, receiptRequest);
  }

}
