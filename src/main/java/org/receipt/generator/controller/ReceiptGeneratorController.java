package org.receipt.generator.controller;

import com.google.gson.JsonObject;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.receipt.generator.model.ReceiptPointsResponse;
import org.receipt.generator.model.ReceiptProcessorResponse;
import org.receipt.generator.model.ReceiptRequest;
import org.receipt.generator.service.ReceiptProcessorService;
import org.receipt.generator.util.JsonToReceiptRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReceiptGeneratorController {

  JsonToReceiptRequest jsonToReceiptRequest;
  @Autowired
  ReceiptProcessorService receiptProcessorService;

  @PostMapping("/process")
    public ResponseEntity<ReceiptProcessorResponse> processReceipts(@RequestBody String receiptRequestJson) {
    ReceiptRequest receiptRequest = JsonToReceiptRequest.fromJson(receiptRequestJson);
      return ResponseEntity.status(HttpStatus.CREATED).body(receiptProcessorService.processReceipts(receiptRequest));
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<ReceiptPointsResponse> getPoints(@PathVariable UUID id) {
      return ResponseEntity.status(HttpStatus.OK).body(receiptProcessorService.getPoints(id));
    }
}
