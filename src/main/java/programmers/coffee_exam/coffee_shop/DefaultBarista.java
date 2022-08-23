package programmers.coffee_exam.coffee_shop;

import programmers.coffee_exam.coffee_shop.coffee.Americano;
import programmers.coffee_exam.coffee_shop.coffee.Cappuccino;
import programmers.coffee_exam.coffee_shop.coffee.CaramelMacchiato;
import programmers.coffee_exam.coffee_shop.coffee.Coffee;
import programmers.coffee_exam.coffee_shop.coffee.Espresso;
import programmers.coffee_exam.coffee_shop.coffee.Menu;

public class DefaultBarista implements Barista {

  @Override
  public Coffee makeCoffee(Menu name) {
    switch (name) {
      case ESPRESSO:
        return new Espresso();
      case AMERICANO:
        return new Americano();
      case CARMEL_MACCHIATO:
        return new CaramelMacchiato();
      case CAPPUCCINO:
        return new Cappuccino();
      default:
        throw new IllegalArgumentException("커피를 만들 수 없는 커피 타입입니다.");
    }
  }
}
