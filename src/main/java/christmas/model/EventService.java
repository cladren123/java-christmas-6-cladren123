package christmas.model;


import christmas.constant.menu.Menu;
import christmas.constant.message.BenefitMessage;
import christmas.constant.message.OutputMessage;

import java.util.Map;

/**
 * 로직 처리
 */
public class EventService {

  private final Order order;
  private final Event event;

  public EventService(int date, Map<String, Integer> inputOrder) {
    this.order = new Order(date, Converter.convertOrder(inputOrder));
    this.event = new Event(Converter.benefitTotal(order));
  }

  // 날짜
  public int getDate() {
    return order.getDate();
  }

  // 주문 메뉴
  public Map<String, Integer> orderMenu() {
    return order.orderMenu();
  }


  // 할인 전 총 주문 금액
  public int orderMoney() {
    return order.calculateOrderMoney();
  }

  // 증정 메뉴
  public String giveaway() {
    if(order.giveawayEvent() == Menu.CHAMPAGNE.getPrice()) {
      return OutputMessage.GIVEAWAY_MENU_TRUE.getMessage();
    }
    return OutputMessage.NOTHING.getMessage();
  }

  // 혜택 내용 : 0 제외
  public Map<BenefitMessage, Integer> benefit() {
    return event.benefit();
  }

  // 총 혜택 금액
  public int benefitMoney() {
    return event.benefitMoney();
  }

  // 할인 후 예상 결제 금액
  public int orderMoneyAfterBenefit() {
    return order.calculateOrderMoney() - event.discountMoney();
  }

  // 12월 이벤트 뱃지
  public String badgeEvent() {
    return event.badgeEvent();
  }




}
