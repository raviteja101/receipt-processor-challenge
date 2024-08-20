package org.receipt.generator.service;

import java.util.UUID;
import org.receipt.generator.model.ReceiptPointsResponse;
import org.receipt.generator.model.ReceiptProcessorResponse;
import org.receipt.generator.model.ReceiptRequest;

public interface ReceiptProcessorService {

  ReceiptProcessorResponse processReceipts(ReceiptRequest receiptRequest);

  ReceiptPointsResponse getPoints(UUID id);
}
