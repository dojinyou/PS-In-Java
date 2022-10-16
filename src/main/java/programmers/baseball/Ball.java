package programmers.baseball;

public class Ball {

  private static final int MIN_NUMBER = 1;

  private static final int MAX_NUMBER = 9;

  private final int number;

  private Ball(int number) {
    this.number = number;
  }

  public static Ball valueOf(int number) {
    validate(number);
    return new Ball(number);
  }

  public static Ball getRandomBall() {
    int number = (int)(Math.random() * MAX_NUMBER) + MIN_NUMBER;
    validate(number);
    return new Ball(number);
  }

  private static void validate(int number) {
    if (number < MIN_NUMBER || MAX_NUMBER < number) {
      throw new IllegalArgumentException();
    }
  }
}
