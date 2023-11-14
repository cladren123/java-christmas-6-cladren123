package christmas.model;

import christmas.constant.menu.Menu;
import christmas.constant.message.BenefitMessage;
import christmas.constant.number.Number;
import christmas.constant.number.SpecialDay;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Event {

  private final Order order;
  private final Map<BenefitMessage, Integer> benefit;

  Event(Order order) {
    this.order = order;
    this.benefit = benefitTotal(order);
  }

  // 혜택 집계
  public Map<BenefitMessage, Integer> benefitTotal(Order order) {
    Map<BenefitMessage, Integer> benefit = new HashMap<>();
    benefit.put(BenefitMessage.CHRISTMAS_D_DAY,order.christmasDdayDiscount());
    benefit.putAll(order.dayDiscount());
    benefit.put(BenefitMessage.SPECIAL_DISCOUNT, order.specialDiscount());
    benefit.put(BenefitMessage.GIVEAWAY_EVENT, order.giveawayEvent());
    return benefit;
  }








}
