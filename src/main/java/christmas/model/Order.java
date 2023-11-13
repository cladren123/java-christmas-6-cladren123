package christmas.model;

import java.util.Map;

/**
 * 주문을 저장하는 class
 */
public class Order {

  private final int date;
  private final Map<String, Integer> order;

  public Order(int date, Map<String, Integer> order) {
    this.date = date;
    this.order = order;
  }



}
