package christmas.validator;


import christmas.constant.menu.Menu;
import christmas.constant.menu.MenuCategory;
import jdk.jfr.Category;

import java.io.IOException;
import java.util.Map;

/**
 * 검증 작업을 수행
 */
public class Validate {


  // 숫자인지 검증
  public static void validateNumber(String input) {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException();
    }
  }

  // 날짜의 범위 검증
  public static void validateDateNumberRange(int date) {
    if(date < 1 || date > 31) {
      throw new IllegalArgumentException();
    }
  }

  // 메뉴가 있는지 검증
  public static Menu validateMenu(String name) {
    for(Menu menu : Menu.values()) {
      if (menu.getName().equals(name)) {
        return menu;
      }
    }
    throw new IllegalArgumentException();
  }

  // 메뉴 개수가 1이상 20이하인지 확인
  public static void validateMenuNumberRange(int number) {
    if(number < 1 || number > 20) {
      throw new IllegalArgumentException();
    }
  }

  // 메뉴가 중복인지 검증
  public static void validateMenuDuplicated(Map<String, Integer> order, String menuName) {
    if (order.containsKey(menuName)) {
      throw new IllegalArgumentException();
    }
  }

  // 메뉴의 개수가 없는 경우 검증
  public static void validateMenuHaveNumber(String[] data) {
    if(data.length != 2) {
      throw new IllegalArgumentException();
    }
  }

  // 음료만 있는지 확인
  public static void validateMenuOnlyBeverage(Map<Menu, Integer> order) {
    for(Menu menu : order.keySet()) {
      if(!menu.getCategory().equals(MenuCategory.BEVERAGE)) {
        return;
      }
    }
    throw new IllegalArgumentException();
  }

  // 메뉴 개수가 20개 이하인지 검증
  public static void validateMenuMaximum(Map<Menu, Integer> order) {
    int count = 0;
    for (Menu menu : order.keySet()) {
      count += order.get(menu);
    }
    if(count > 20) {
      throw new IllegalArgumentException();
    }
  }



}
