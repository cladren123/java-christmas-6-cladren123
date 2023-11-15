package christmas.model;

import christmas.constant.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OrderTest {


  @DisplayName("Order 생성자 검증 - 옳은 입력")
  @Test
  void order_validInput() {
    int date = 3;
    Map<Menu, Integer> inputOrder = new LinkedHashMap<>();
    inputOrder.put(Menu.MUSHROOM_SOUP, 1);
    inputOrder.put(Menu.ZERO_COLA, 1);
    assertDoesNotThrow(() -> new Order(3, inputOrder));
  }

  @DisplayName("Order 생성자 검증 - 예외 입력")
  @MethodSource("provideOrderData")
  @ParameterizedTest
  void order_invalidInput(int date, Map<Menu, Integer> inputOrder) {
    assertThrows(IllegalArgumentException.class, () -> new Order(date, inputOrder));
  }

  // order의 예외 입력 모음
  static Stream<Arguments> provideOrderData() {
    return Stream.of(
            arguments(3, new LinkedHashMap<>(Map.of(Menu.MUSHROOM_SOUP, 25, Menu.ICE_CREAM, 6))),
            arguments(3, new LinkedHashMap<>(Map.of(Menu.ZERO_COLA,1, Menu.RED_WINE,1)))
    );
  }

  @DisplayName("메뉴 목록 반환 - 한 개")
  @Test
  void orderMenuOne() {
    // given
    int date = 3;
    Map<Menu, Integer> inputOrder = new LinkedHashMap<>(Map.of(Menu.MUSHROOM_SOUP,1 ));
    Order order = new Order(3, inputOrder);

    // when
    Map<String, Integer> result = order.orderMenu();

    // then
    Map<String, Integer> expected = new LinkedHashMap<>(Map.of(Menu.MUSHROOM_SOUP.getName(),1));
    assertEquals(result, expected);
  }

  @DisplayName("메뉴 목록 반환 - 여러 개")
  @Test
  void orderMenuMany() {
    // given
    int date = 3;
    Map<Menu, Integer> inputOrder = new LinkedHashMap<>(Map.of(Menu.MUSHROOM_SOUP, 5, Menu.CHAMPAGNE, 1));
    Order order = new Order(3, inputOrder);

    // when
    Map<String, Integer> result = order.orderMenu();

    // then
    Map<String, Integer> expected = new LinkedHashMap<>(Map.of(Menu.MUSHROOM_SOUP.getName(), 5, Menu.CHAMPAGNE.getName(), 1));
    assertEquals(result, expected);
  }

  @DisplayName("디저트 메뉴 - 한 개")
  @Test
  void countDessertMenu_One() {
    // given
    int date = 3;
    Map<Menu, Integer> inputOrder = new LinkedHashMap<>(Map.of(
            Menu.MUSHROOM_SOUP, 5,
            Menu.CHAMPAGNE, 1,
            Menu.CHOCOLATE_CAKE, 2
    ));
    Order order = new Order(date, inputOrder);

    // when
    int result = order.countDessertMenu();

    // then
    int expected = 2;
    assertEquals(result, expected);
  }

  @DisplayName("디저트 메뉴 - 여러 개")
  @Test
  void countDessertMenu_Many() {
    // given
    int date = 3;
    Map<Menu, Integer> inputOrder = new LinkedHashMap<>(Map.of(
            Menu.MUSHROOM_SOUP, 5,
            Menu.CHAMPAGNE, 1,
            Menu.CHOCOLATE_CAKE, 2,
            Menu.ICE_CREAM, 3
    ));
    Order order = new Order(date, inputOrder);

    // when
    int result = order.countDessertMenu();

    // then
    int expected = 5;
    assertEquals(result, expected);
  }







}