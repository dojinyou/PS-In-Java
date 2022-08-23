package programmers.coffee_exam.customer;

import programmers.coffee_exam.coffee_shop.Barista;
import programmers.coffee_exam.coffee_shop.coffee.Coffee;
import programmers.coffee_exam.coffee_shop.coffee.Menu;

public class DefaultCustomer implements Customer {

  private final Menu menu;

  private final Barista barista;

  public DefaultCustomer(
      Menu menu,
      Barista barista
  ) {
    this.menu = menu;
    this.barista = barista;
  }

  @Override
  public Coffee order(
      String menuName
  ) {

    Menu orderMenu = menu.findByKoreanName(menuName);

    return barista.makeCoffee(orderMenu);
  }
}
