package christmas.model;

import christmas.constant.badge.EventBadge;
import christmas.constant.message.BenefitMessage;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 이벤트, 혜택 관련 로직 수행
 */
public class Event {

  private final Map<BenefitMessage, Integer> benefit;

  public Event(Map<BenefitMessage, Integer> benefit) {
    this.benefit = benefit;
  }



  // 유효한 혜택
  // 혜택 내용 : 0 제외
  public Map<BenefitMessage, Integer> benefit() {
    Map<BenefitMessage, Integer> result = new LinkedHashMap<>();
    for (BenefitMessage benefitMessage : benefit.keySet()) {
      if(benefit.get(benefitMessage) > 0) {
        result.put(benefitMessage, benefit.get(benefitMessage));
      }
    }
    return result;
  }

  // 총 혜택 금액 계산
  public int benefitMoney() {
    int benefitMoney = 0;
    for(BenefitMessage benefitMessage : benefit.keySet()) {
      benefitMoney += benefit.get(benefitMessage);
    }
    return benefitMoney;
  }

  // 총 할인 금액 계산
  public int discountMoney() {
    int discountMoney = 0;
    for(BenefitMessage benefitMessage : benefit.keySet()) {
      if(benefitMessage.getMessage().equals(BenefitMessage.GIVEAWAY_EVENT.getMessage())) continue;
      discountMoney += benefit.get(benefitMessage);
    }
    return discountMoney;
  }


  // 배지 부여
  public String badgeEvent() {
    int discountMoney = benefitMoney();
    if (discountMoney > EventBadge.SANTA.getPrice()) return EventBadge.SANTA.getName();
    if (discountMoney > EventBadge.TREE.getPrice()) return EventBadge.TREE.getName();
    if (discountMoney > EventBadge.STAR.getPrice()) return EventBadge.STAR.getName();
    return EventBadge.NOTHING.getName();
  }











}
