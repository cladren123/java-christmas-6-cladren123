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

  @DisplayName("총혜택 금액 계산")
  @Test
  void benefitMoney() {
    // given
    Map<BenefitMessage, Integer> benefit = new LinkedHashMap<>(Map.of(
            BenefitMessage.CHRISTMAS_D_DAY, 1300,
            BenefitMessage.WEEKDAY_DISCOUNT, 2023,
            BenefitMessage.GIVEAWAY_EVENT, 0
    ));
    Event event = new Event(benefit);

    // when
    int result = event.benefitMoney();

    // then
    int expect = 1300 + 2023;
    assertEquals(result, expect);
  }

  @DisplayName("배지 부여_산타")
  @Test
  void badgeEvent_santa() {
    // given
    Map<BenefitMessage, Integer> benefit = new LinkedHashMap<>(Map.of(
            BenefitMessage.CHRISTMAS_D_DAY, 1300,
            BenefitMessage.WEEKDAY_DISCOUNT, 2023,
            BenefitMessage.GIVEAWAY_EVENT, 25000
    ));
    Event event = new Event(benefit);

    // when
    String result = event.badgeEvent();

    // then
    String expect = "산타";
    assertEquals(result, expect);
  }

  @DisplayName("배지 부여_트리")
  @Test
  void badgeEvent_tree() {
    // given
    Map<BenefitMessage, Integer> benefit = new LinkedHashMap<>(Map.of(
            BenefitMessage.CHRISTMAS_D_DAY, 1300,
            BenefitMessage.WEEKDAY_DISCOUNT, 10115
    ));
    Event event = new Event(benefit);

    // when
    String result = event.badgeEvent();

    // then
    String expect = "트리";
    assertEquals(result, expect);
  }

  @DisplayName("배지 부여_별")
  @Test
  void badgeEvent_star() {
    // given
    Map<BenefitMessage, Integer> benefit = new LinkedHashMap<>(Map.of(
            BenefitMessage.CHRISTMAS_D_DAY, 1300,
            BenefitMessage.WEEKDAY_DISCOUNT, 4046
    ));
    Event event = new Event(benefit);

    // when
    String result = event.badgeEvent();

    // then
    String expect = "별";
    assertEquals(result, expect);
  }

  @DisplayName("배지 부여_없음")
  @Test
  void badgeEvent_nothing() {
    // given
    Map<BenefitMessage, Integer> benefit = new LinkedHashMap<>(Map.of(
            BenefitMessage.CHRISTMAS_D_DAY, 1300
    ));
    Event event = new Event(benefit);

    // when
    String result = event.badgeEvent();

    // then
    String expect = "없음";
    assertEquals(result, expect);
  }



}