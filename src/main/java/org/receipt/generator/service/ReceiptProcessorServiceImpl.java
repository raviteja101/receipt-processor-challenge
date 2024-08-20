package org.receipt.generator.service;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.receipt.generator.model.ReceiptPointsResponse;
import org.receipt.generator.model.ReceiptProcessorResponse;
import org.receipt.generator.model.ReceiptRequest;
import org.receipt.generator.repository.ReceiptProcessorInMemoryStore;
import org.receipt.generator.util.PointsCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReceiptProcessorServiceImpl implements ReceiptProcessorService {

  @Autowired
  PointsCalculator pointsCalculator;

  @Autowired
  ReceiptProcessorInMemoryStore receiptProcessorInMemoryStore;


  @Override
  public ReceiptProcessorResponse processReceipts(ReceiptRequest receiptRequest) {
    ReceiptProcessorResponse response = new ReceiptProcessorResponse();
    UUID id = UUID.randomUUID();
    receiptProcessorInMemoryStore.putReceiptDetails(id, receiptRequest);
    response.setId(id);
    return response;
  }

  @Override
  public ReceiptPointsResponse getPoints(UUID id) {
    ReceiptPointsResponse response = new ReceiptPointsResponse();
    try {
      ReceiptRequest receiptRequest = receiptProcessorInMemoryStore.getReceiptDetails(id);
      if (ObjectUtils.isNotEmpty(receiptRequest)) {
        int points = pointsCalculator.processRules(receiptRequest);
        response.setPoints(points);
      }
    } catch (Exception e) {
      log.error("Error occurred while fetching points for id: {} due to: {}", id, e.getMessage());
    }
    return response;
  }
}
