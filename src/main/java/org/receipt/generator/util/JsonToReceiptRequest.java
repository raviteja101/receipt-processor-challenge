package org.receipt.generator.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.receipt.generator.model.ReceiptItem;
import org.receipt.generator.model.ReceiptRequest;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class JsonToReceiptRequest {

  public static ReceiptRequest fromJson(String jsonString) {
    try {
      JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
      String retailer = jsonObject.get("retailer").getAsString();
      LocalDate purchaseDate = LocalDate.parse(jsonObject.get("purchaseDate").getAsString());
      LocalTime purchaseTime = LocalTime.parse(jsonObject.get("purchaseTime").getAsString());
      double total = Double.parseDouble(jsonObject.get("total").getAsString());

      JsonArray itemsArray = jsonObject.getAsJsonArray("items");
      List<ReceiptItem> items = new ArrayList<>();
      for (int i = 0; i < itemsArray.size(); i++) {
        JsonObject itemObject = itemsArray.get(i).getAsJsonObject();
        ReceiptItem item = ReceiptItem.builder()
                                      .shortDescription(itemObject.get("shortDescription").getAsString())
                                      .price(Double.parseDouble(itemObject.get("price").getAsString()))
                                      .build();
        items.add(item);
      }

      return ReceiptRequest.builder()
                           .retailer(retailer)
                           .purchaseDate(purchaseDate)
                           .purchaseTime(purchaseTime)
                           .items(items)
                           .total(total)
                           .build();
    } catch (Exception e) {
      log.error("Exception occurred during parsing input request due to: {}", e.getMessage());
      throw e;
    }

  }

}
