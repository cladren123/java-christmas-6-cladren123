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
      validate.validateMenu(dataSplitHyphen[0]);
      validate.validateNumber(dataSplitHyphen[1]);
      int number = Integer.parseInt(dataSplitHyphen[1]);
      validate.validateMenuNumberRange(number);
      validate.validateMenuDuplicated(order, dataSplitHyphen[0]);
      order.put(dataSplitHyphen[0], number);
    }
    return order;
  }



}
