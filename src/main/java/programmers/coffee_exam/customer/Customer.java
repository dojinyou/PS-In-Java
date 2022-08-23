package programmers.coffee_exam.customer;

import programmers.coffee_exam.coffee_shop.coffee.Coffee;

public interface Customer {

  Coffee order(
      String menuName
  );
}
