package problemsolving.baseball;

public class Result {

  private boolean isFinished = false;

  private int strikeNumber = 0;
  private int ballNumber = 0;

  public int getStrikeNumber() {
    return strikeNumber;
  }

  public int getBallNumber() {
    return ballNumber;
  }

  public void addStrikeNumber() {
    if (!isFinished) {
      this.strikeNumber++;
    }
  }

  public void addBallNumber() {
    if (!isFinished) {
      this.ballNumber++;
    }
  }

  public void isFinish() {
    isFinished = true;
  }

  @Override
  public String toString() {
    return "Result{" +
        "isFinished=" + isFinished +
        ", strikeNumber=" + strikeNumber +
        ", ballNumber=" + ballNumber +
        '}';
  }
}
