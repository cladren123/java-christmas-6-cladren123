package christmas.model;

import christmas.constant.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
  
  @DisplayName("String에서 Menu로 변환")
  @Test
  void convertOrder() {
    // given
    Map<String, Integer> inputOrder = new LinkedHashMap<>(Map.of(
            "양송이수프",1,
            "제로콜라",2
    ));

    // when
    Map<Menu, Integer> result = Converter.convertOrder(inputOrder);

    // then
    Map<Menu, Integer> expect = new LinkedHashMap<>(Map.of(
            Menu.MUSHROOM_SOUP, 1,
            Menu.ZERO_COLA, 2
    ));
    assertEquals(result, expect);
  }

}