package problemsolving.coffee_exam.customer;

import problemsolving.coffee_exam.coffee_shop.coffee.Coffee;

public interface Customer {

  Coffee order(
      String menuName
  );
}
