package christmas.model;

import java.util.Map;

/**
 * 주문을 저장하는 class
 */
public class Order {

  private final Map<String, Integer> order;

  public Order(Map<String, Integer> order) {
    this.order = order;
  }



}
