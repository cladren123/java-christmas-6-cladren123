package christmas.model;

import christmas.constant.message.BenefitMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

  @DisplayName("유효한 혜택")
  @Test
  void benefit() {
    // given
    Map<BenefitMessage, Integer> benefit = new LinkedHashMap<>(Map.of(
            BenefitMessage.CHRISTMAS_D_DAY, 1300,
            BenefitMessage.WEEKDAY_DISCOUNT, 2023,
            BenefitMessage.GIVEAWAY_EVENT, 0
    ));
    Event event = new Event(benefit);

    // when
    Map<BenefitMessage, Integer> result = event.benefit();

    // then
    Map<BenefitMessage, Integer> expect = new LinkedHashMap<>(Map.of(
            BenefitMessage.CHRISTMAS_D_DAY, 1300,
            BenefitMessage.WEEKDAY_DISCOUNT, 2023
    ));
    assertEquals(result, expect);
  }



}