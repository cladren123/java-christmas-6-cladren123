package christmas.validator;


import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuCategory;
import jdk.jfr.Category;

import java.io.IOException;
import java.util.Map;

/**
 * 검증 작업을 수행하는 클래스
 */
public class Validate {


  // 숫자인지 검증
  public void validateNumber(String input) {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException();
    }
  }

  // 날짜의 범위 검증
  public void validateDateNumberRange(int date) {
    if(date < 1 || date > 31) {
      throw new IllegalArgumentException();
    }
  }




  // 메뉴가 있는지 검증
  public Menu validateMenu(String name) {
    for(Menu menu : Menu.values()) {
      if (menu.getName().equals(name)) {
        return menu;
      }
    }
    throw new IllegalArgumentException();
  }

  // 메뉴 개수가 1이상 20이하인지 확인
  public void validateMenuNumberRange(int number) {
    if(number < 1 || number > 20) {
      throw new IllegalArgumentException();
    }
  }

  // 메뉴가 중복인지 검증
  public void validateMenuDuplicated(Map<String, Integer> order, String menuName) {
    if (order.containsKey(menuName)) {
      throw new IllegalArgumentException();
    }
  }

  // 음료만 있는지 확인
  public void validateMenuOnlyBeverage(Map<String, Integer> orderCategory) {
    if (orderCategory.size() == 1 && orderCategory.containsKey("beverage")) {
      throw new IllegalArgumentException();
    }
  }

  // 메뉴 개수가 20개 이하인지 검증
  public void validateMenuMaximum(Map<String, Integer> order) {
    int count = 0;
    for (String menu : order.keySet()) {
      count += order.get(menu);
    }
    if(count > 20) {
      throw new IllegalArgumentException();
    }
  }



}
