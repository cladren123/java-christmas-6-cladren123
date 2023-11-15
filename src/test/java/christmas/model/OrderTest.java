package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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

  @DisplayName("Order 생성자 검증 - 예외 입력")
  @MethodSource("provideOrderData")
  @ParameterizedTest
  void order_invalidInput(int date, Map<String, Integer> inputOrder) {
    assertThrows(IllegalArgumentException.class, () -> new Order(date, inputOrder));
  }

  // order의 예외 입력 모음
  static Stream<Arguments> provideOrderData() {
    return Stream.of(
            arguments(3, new LinkedHashMap<>(Map.of("양송이수프",25, "아이스크림",6))),
            arguments(3, new LinkedHashMap<>(Map.of("제로콜라",1, "레드와인",1)))
    );
  }



}