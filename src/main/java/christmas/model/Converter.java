package christmas.model;


import christmas.constant.menu.Menu;
import christmas.validator.Validate;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 데이터 변환기
 */
public class Converter {

  // String에서 Menu 변환
  public static Map<Menu, Integer> convertOrder(Map<String, Integer> inputOrder) {
    Map<Menu, Integer> order = new LinkedHashMap<>();
    for(String name : inputOrder.keySet()) {
      Menu menu = Validate.validateMenu(name);
      order.put(menu, inputOrder.get(name));
    }
    return order;
  }
}
