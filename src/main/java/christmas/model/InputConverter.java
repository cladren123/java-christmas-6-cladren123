package christmas.model;


import christmas.validator.Validate;

import java.util.HashMap;
import java.util.Map;

/**
 * 입력값을 원하는 형태로 변환
 */
public class InputConverter {

  private final Validate validate = new Validate();

  // 날짜 입력값을 숫자로 변환
  public int convertDate(String input) {
    validate.validateNumber(input);
    int date = Integer.parseInt(input);
    validate.validateDateNumberRange(date);
    return date;
  }

  // 메뉴 입력값을 Map<이름, 갯수> 로 변환
  public Map<String, Integer> convertOrder(String input) {
    Map<String, Integer> order = new HashMap<>();
    String[] inputSplitRest = input.split(",");
    for (String data : inputSplitRest) {
      String[] dataSplitHyphen = data.split("-");
      validate.validateMenuHaveNumber(dataSplitHyphen);
      String menu = convertMenu(dataSplitHyphen[0]);
      int number = convertNumber(dataSplitHyphen[1]);
      validate.validateMenuDuplicated(order, menu);
      order.put(menu, number);
    }
    return order;
  }

  // 메뉴 검증 후 반환
  public String convertMenu(String inputMenu) {
    validate.validateMenu(inputMenu);
    return inputMenu;
  }

  // 메뉴 개수 검증 후 반환
  public int convertNumber(String inputNumber) {
    validate.validateNumber(inputNumber);
    int number = Integer.parseInt(inputNumber);
    validate.validateMenuNumberRange(number);
    return number;
  }


}
