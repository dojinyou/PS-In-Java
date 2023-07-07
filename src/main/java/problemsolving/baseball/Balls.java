package problemsolving.baseball;

import java.util.List;
import java.util.Set;

public class Balls {

  private final List<Ball> balls;

  public Balls(Set<Ball> balls) {
    this.balls = List.of(balls.toArray(new Ball[0]));
  }

  public int getSize() {
    return balls.size();
  }

  public Result makeResult(Balls other) {
    if (other.getSize() != getSize()) {
      throw new IllegalArgumentException();
    }

    Result result = new Result();

    for (int i = 0; i < balls.size(); i++) {
      Ball checkedBall = balls.get(i);
      other.check(checkedBall, i, result);
    }

    result.isFinish();

    return result;
  }

  private void check(
      Ball checkedBall,
      int idx,
      Result result
  ) {
    int ballIdx = balls.indexOf(checkedBall);

    if (ballIdx == -1) {
      return;
    }

    if (ballIdx == idx) {
      result.addStrikeNumber();
      return;
    }

    result.addBallNumber();

  }
}
