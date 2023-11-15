package christmas.controller;

import christmas.constant.menu.Menu;
import christmas.constant.message.ErrorMessage;
import christmas.constant.message.InputMessage;
import christmas.model.*;
import christmas.view.InputView;
import christmas.view.OutputView;
import org.mockito.internal.matchers.Or;

import java.util.Map;

/**
 * 전체적인 흐름을 설정합니다.
 */
public class EventPlanner {

  // 흐름 제어
  public void start() {
    InputView.welcome();
    int date = readDate();
    Order order = readOrder(date);
    Event event = new Event(Converter.benefitTotal(order));
    EventService eventService = new EventService(order, event);
    print(eventService);
  }

  // 결과 출력
  public void print(EventService eventService) {
    OutputView.printIntro(eventService.getDate());
    OutputView.printMenu(eventService.orderMenu());
    OutputView.printOrderMoney(eventService.orderMoney());
    OutputView.printGiveaway(eventService.giveaway());
    OutputView.printBenefit(eventService.benefit());
    OutputView.printBenefitMoney(eventService.benefitMoney());
    OutputView.printOrderMoneyAfterDiscount(eventService.orderMoneyAfterBenefit());
    OutputView.printEventBadge(eventService.badgeEvent());
  }



  // 날짜 입력
  public int readDate() {
    while(true) {
      String input = InputView.readDate();
      try {
        return InputConverter.convertDate(input);
      }
      catch (IllegalArgumentException e) {
        System.out.println(ErrorMessage.INVALID_DATE.getMessage());
      }
    }
  }

  // 메뉴 입력
  public Order readOrder(int date) {
    while (true) {
      String input = InputView.readMenu();
      try {
        Map<String, Integer> inputOrder = InputConverter.convertOrder(input);
        Map<Menu, Integer> inputMenu = Converter.convertOrder(inputOrder);
        Order order = new Order(date, inputMenu);
        return order;
      }
      catch (IllegalArgumentException e) {
        System.out.println(ErrorMessage.INVALID_MENU.getMessage());
      }
    }
  }




}
