package christmas.view;


import christmas.constant.message.BenefitMessage;
import christmas.constant.message.OutputMessage;

import java.util.Map;

/**
 * 출력 화면 생성
 */
public class OutputView {

  // 인트로 문구 출력
  public static void printIntro(int date) {
    System.out.println(String.format(OutputMessage.INTRO.getMessage(),date));
    System.out.println();
  }

  // 주문한 메뉴와 개수 출력
  public static void printMenu(Map<String, Integer> orderMenu) {
    System.out.println(OutputMessage.ORDER_MENU.getMessage());
    for (String name : orderMenu.keySet()) {
      System.out.println(String.format(OutputMessage.ORDER_MENU_FORMAT.getMessage(), name, orderMenu.get(name)));
    }
    System.out.println();
  }
  
  // 할인 전 총 주문 금액 출력
  public static void printOrderMoney(int orderMoney) {
    System.out.println(OutputMessage.ORDER_MONEY.getMessage());
    System.out.println(String.format(OutputMessage.ORDER_MONEY_FORMAT.getMessage(), orderMoney));
    System.out.println();
  }

  // 증정 메뉴 출력
  public static void printGiveaway(String message) {
    System.out.println(OutputMessage.GIVEAWAY_MENU.getMessage());
    System.out.println(message);
    System.out.println();
  }

  // 혜택 내역 출력
  public static void printBenefit(Map<BenefitMessage, Integer> benefit) {
    System.out.println(OutputMessage.BENEFIT.getMessage());
    if(benefit.size() == 0) {
      System.out.println(OutputMessage.NOTHING.getMessage());
      System.out.println();
      return;
    }
    for (BenefitMessage benefitMessage : benefit.keySet()) {
      System.out.println(String.format(OutputMessage.BENEFIT_FORMAT.getMessage(), benefitMessage.getMessage(), benefit.get(benefitMessage)));
    }
    System.out.println();
  }

  // 총혜택 금액 출력
  public static void printBenefitMoney(int benefitMoney) {
    System.out.println(OutputMessage.BENEFIT_MONEY.getMessage());
    System.out.println(String.format(OutputMessage.BENEFIT_MONEY_FORMAT.getMessage(), benefitMoney * -1));
    System.out.println();
  }

  // 할인 후 예상 결제 금액 출력
  public static void printOrderMoneyAfterDiscount(int orderMoneyAfterBenefit) {
    System.out.println(OutputMessage.ORDER_MONEY_AFTER_DISCOUNT.getMessage());
    System.out.println(String.format(OutputMessage.ORDER_MONEY_AFTER_DISCOUNT_FORMAT.getMessage(), orderMoneyAfterBenefit));
    System.out.println();
  }

  // 12월 이벤트 배지 출력
  public static void printEventBadge(String badge) {
    System.out.println(OutputMessage.EVENT_BADGE.getMessage());
    System.out.println(badge);
  }
}
