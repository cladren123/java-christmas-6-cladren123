package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class OrderTest {


  @DisplayName("Order 생성자 검증 - 옳은 입력")
  @Test
  void order_validInput() {
    int date = 3;
    Map<String, Integer> inputOrder = new LinkedHashMap<>();
    inputOrder.put("양송이수프", 1);
    inputOrder.put("아이스크림", 1);
    assertDoesNotThrow(() -> new Order(3, inputOrder));
  }



}