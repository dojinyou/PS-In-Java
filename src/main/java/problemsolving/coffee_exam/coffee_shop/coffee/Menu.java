package problemsolving.coffee_exam.coffee_shop.coffee;

public enum Menu {
  AMERICANO("아메리카노"),
  CAPPUCCINO("카푸치노"),
  CARMEL_MACCHIATO("카라멜 마끼아또"),
  ESPRESSO("에스프레소");

  private final String koreanName;

  Menu(String koreanName) {
    this.koreanName = koreanName;
  }

  public Menu findByKoreanName(String koreanName) {
    for (Menu menu : values()) {
      if (menu.koreanName.equals(koreanName)) {
        return menu;
      }
    }
    return null;
  }
}
