package problemsolving.baseball;

public class Config {
  private static int COUNT_BALL;

  public static int getCountBall() {
    return COUNT_BALL;
  }

  public static void main(String[] args) {
    Config.COUNT_BALL = Integer.parseInt(args[0]);
  }
}
