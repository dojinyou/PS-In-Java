package programmers.coffee_exam.coffee_shop;

import programmers.coffee_exam.coffee_shop.coffee.Coffee;
import programmers.coffee_exam.coffee_shop.coffee.Menu;

public interface Barista {
  Coffee makeCoffee(Menu name);
}
