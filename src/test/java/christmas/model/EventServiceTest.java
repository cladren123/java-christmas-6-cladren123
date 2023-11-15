package christmas.model;

import christmas.constant.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {

  @DisplayName("할인 후 예상 결제 금액")
  @Test
  void orderMoneyAfterBenefit() {
    // given
    int date = 1;
    Map<Menu, Integer> inputOrder = new LinkedHashMap<>(Map.of(
            Menu.BBQ_RIBS, 1,
            Menu.ICE_CREAM, 2
    ));
    Order order = new Order(date, inputOrder);
    Event event = new Event(Converter.benefitTotal(order));
    EventService eventService = new EventService(order, event);

    // when
    int result = eventService.orderMoneyAfterBenefit();

    // then
    int expect = (54000 + 5000 * 2) - (1000 + 2023);
    assertEquals(result, expect);
  }

}