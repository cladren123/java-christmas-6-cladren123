package christmas.model;


import org.mockito.internal.matchers.Or;

import java.util.Map;

/**
 * 로직 처리
 */
public class EventService {

  private final Order order;
  private final Event event;

  public EventService(int date, Map<String, Integer> order) {
    this.order = new Order(date, order);
    this.event = new Event(this.order);
  }



}
