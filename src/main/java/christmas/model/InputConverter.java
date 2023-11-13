package christmas.model;


import christmas.validator.Validate;

import java.util.HashMap;
import java.util.Map;

/**
 * 입력값을 원하는 형태로 변환
 */
public class InputConverter {


  // 날짜 입력값을 숫자로 변환
  public int convertDate(String input) {
    Validate.validateNumber(input);
    int date = Integer.parseInt(input);
    Validate.validateDateNumberRange(date);
    return date;
  }

  // 메뉴 입력값을 Map<이름, 갯수> 로 변환
  public Map<String, Integer> convertOrder(String input) {
    Map<String, Integer> order = new HashMap<>();
    String[] inputSplitRest = input.split(",");
    for (String data : inputSplitRest) {
      String[] dataSplitHyphen = data.split("-");
      Validate.validateMenuHaveNumber(dataSplitHyphen);
      String menu = convertMenu(dataSplitHyphen[0]);
      int number = convertNumber(dataSplitHyphen[1]);
      Validate.validateMenuDuplicated(order, menu);
      order.put(menu, number);
    }
    return order;
  }

  // 메뉴 검증 후 반환
  public String convertMenu(String inputMenu) {
    Validate.validateMenu(inputMenu);
    return inputMenu;
  }

  // 메뉴 개수 검증 후 반환
  public int convertNumber(String inputNumber) {
    Validate.validateNumber(inputNumber);
    int number = Integer.parseInt(inputNumber);
    Validate.validateMenuNumberRange(number);
    return number;
  }


}
