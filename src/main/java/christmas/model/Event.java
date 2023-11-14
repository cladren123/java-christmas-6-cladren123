package christmas.model;

import christmas.constant.badge.EventBadge;
import christmas.constant.message.BenefitMessage;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Event {

  private final Map<BenefitMessage, Integer> benefit;

  public Event(Order order) {
    this.benefit = benefitTotal(order);
  }

  public Map<BenefitMessage, Integer> getBenefit() {
    return benefit;
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

  // 총 할인 금액 계산
  public int discountMoney() {
    int discountMoney = 0;
    for(BenefitMessage benefitMessage : benefit.keySet()) {
      discountMoney += benefit.get(benefitMessage);
    }
    return discountMoney;
  }

  // 배지 부여
  public String badgeEvent() {
    if (discountMoney() > EventBadge.SANTA.getPrice()) return EventBadge.SANTA.getName();
    if (discountMoney() > EventBadge.TREE.getPrice()) return EventBadge.TREE.getName();
    if (discountMoney() > EventBadge.STAR.getPrice()) return EventBadge.STAR.getName();
    return EventBadge.NOTHING.getName();
  }











}
