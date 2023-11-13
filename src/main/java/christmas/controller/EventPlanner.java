package christmas.controller;

import christmas.constant.message.ErrorMessage;
import christmas.constant.message.InputMessage;
import christmas.model.InputConverter;
import christmas.model.Order;
import christmas.view.InputView;
import org.mockito.internal.matchers.Or;

import java.util.Map;

/**
 * 전체적인 흐름을 설정합니다.
 */
public class EventPlanner {

  private final InputView inputView = new InputView();
  private final InputConverter inputConverter = new InputConverter();



  public void start() {
    System.out.println(InputMessage.WELCOME.getMessage());
    int date = readDate();
    readOrder(date);
  }

  // 날짜 입력
  public int readDate() {
    while(true) {
      String input = inputView.readDate();
      try {
        return inputConverter.convertDate(input);
      }
      catch (IllegalArgumentException e) {
        System.out.println(ErrorMessage.INVALID_DATE.getMessage());
      }
    }
  }

  // 메뉴 입력
  public Order readOrder(int date) {
    while (true) {
      String input = inputView.readMenu();
      try {
        Map<String, Integer> order = inputConverter.convertOrder(input);
        return new Order(date, order);
      }
      catch (IllegalArgumentException e) {
        System.out.println(ErrorMessage.INVALID_MENU.getMessage());
      }
    }
  }




}
