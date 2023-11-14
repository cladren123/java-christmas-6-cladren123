package christmas.view;


import christmas.constant.message.OutputMessage;

import java.util.Map;

/**
 * 출력 화면 생성
 */
public class OutputView {

  // 인트로 문구 출력
  public void printIntro() {
    System.out.println(OutputMessage.INTRO.getMessage());
    System.out.println();
  }

  // 주문한 메뉴와 개수 출력
  public void printMenu(Map<String, Integer> orderMenu) {
    System.out.println(OutputMessage.ORDER_MENU.getMessage());
    for (String name : orderMenu.keySet()) {
      System.out.println(String.format(OutputMessage.ORDER_MENU_FORMAT.getMessage(), name, orderMenu.get(name)));
    }
    System.out.println();
  }
  
  // 할인 전 총 주문 금액 출력
  public void printOrderMoney(int orderMoney) {
    System.out.println(OutputMessage.ORDER_MONEY.getMessage());
    System.out.println(String.format(OutputMessage.ORDER_MONEY_FORMAT.getMessage(), orderMoney));
    System.out.println();
  }




  
}
