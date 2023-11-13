package christmas.model;

import christmas.constant.menu.Menu;
import christmas.validator.Validate;

import java.util.HashMap;
import java.util.Map;

/**
 * 주문을 저장하는 class
 */
public class Order {

  private final int date;
  private final Map<Menu, Integer> order;

  public Order(int date, Map<String, Integer> inputOrder) {
    this.date = date;
    Map<Menu, Integer> order = convertOrder(inputOrder);
    Validate.validateMenuOnlyBeverage(order);
    Validate.validateMenuMaximum(order);
    this.order = order;
  }

  public Map<Menu, Integer> convertOrder(Map<String, Integer> inputOrder) {
    Map<Menu, Integer> order = new HashMap<>();
    for(String name : inputOrder.keySet()) {
      Menu menu = Validate.validateMenu(name);
      order.put(menu, inputOrder.get(name));
    }
    return order;
  }








}
