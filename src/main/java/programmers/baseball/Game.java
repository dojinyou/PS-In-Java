package programmers.baseball;

public class Game {

  private final Balls computerBalls;

  private final Balls userBalls;

  public Game(
      Balls computerBalls,
      Balls userBalls
  ) {
    this.computerBalls = computerBalls;
    this.userBalls = userBalls;
  }

  public Result check() {
    return computerBalls.makeResult(userBalls);
  }
}
