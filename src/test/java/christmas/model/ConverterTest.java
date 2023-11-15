package christmas.model;

import christmas.constant.menu.Menu;
import christmas.constant.message.BenefitMessage;
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

  @DisplayName("order에서 혜택 내역 변환")
  @Test
  void benefitTotal() {
    // given
    int date = 10;
    Map<Menu, Integer> inputOrder = new LinkedHashMap<>(Map.of(
            Menu.T_BONE_STEAK, 3,
            Menu.BBQ_RIBS, 1,
            Menu.ZERO_COLA, 2,
            Menu.ICE_CREAM, 1
    ));
    Order order = new Order(date, inputOrder);

    // when
    Map<BenefitMessage, Integer> result = Converter.benefitTotal(order);

    // then
    Map<BenefitMessage, Integer> expect = new LinkedHashMap<>(Map.of(
            BenefitMessage.CHRISTMAS_D_DAY, 1900,
            BenefitMessage.WEEKDAY_DISCOUNT, 2023,
            BenefitMessage.SPECIAL_DISCOUNT, 1000,
            BenefitMessage.GIVEAWAY_EVENT, 25000
    ));
    assertEquals(result, expect);
  }

}