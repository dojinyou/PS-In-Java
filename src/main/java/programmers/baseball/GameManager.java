package programmers.baseball;

import java.util.HashSet;
import java.util.Set;

public class GameManager {

  public static final String INPUT_MESSAGE_FOR_USER_BALL = "inputNumber";
  public static final String ERROR_MESSAGE_DUPLICATED_BALL_NUMBER = "ERROR MESSAGE";
  public static final String MESSAGE_FOR_CONTINUE = "계속 할래?";

  private final int countBall;
  private final InputView inputView;
  private final OutputView outputView;

  public GameManager(
      int countBall,
      InputView inputView,
      OutputView outputView
  ) {
    this.countBall = countBall;
    this.inputView = inputView;
    this.outputView = outputView;
  }

  private void run() {
    process(createGame());
  }

  private Game createGame() {
    Balls userBalls = createUserBalls();
    Balls computerBalls = createRandomBalls();

    return new Game(userBalls, computerBalls);
  }

  private void process(
      Game game
  ) {
    Command command = Command.CONTINUE;

    while (command == Command.CONTINUE) {
      Result result = game.check();
      displayResult(result);
      command = checkContinue();
    }
  }

  private Command checkContinue() {
    outputView.display(MESSAGE_FOR_CONTINUE);
    return Command.of(inputView.inputCommand());
  }

  private void displayResult(Result result) {
    outputView.display(result.toString());
  }

  private Balls createRandomBalls() {
    Set<Ball> balls = new HashSet<>();

    while (balls.size() < countBall) {
      Ball newBall = Ball.getRandomBall();
      balls.add(newBall);
    }

    return new Balls(balls);
  }

  private Balls createUserBalls() {
    Set<Ball> balls = new HashSet<>();

    while (balls.size() < countBall) {
      outputView.display(INPUT_MESSAGE_FOR_USER_BALL);
      int number = Integer.parseInt(inputView.inputCommand());
      Ball newBall = null;
      try {
        newBall = Ball.valueOf(number);
      } catch (IllegalArgumentException e) {
        outputView.display(e.getMessage());
      }

      if (balls.contains(newBall)) {
        outputView.display(ERROR_MESSAGE_DUPLICATED_BALL_NUMBER);
        continue;
      }

      balls.add(newBall);
    }

    return new Balls(balls);
  }

  public static void main(String[] args) {
    ConsoleView cv = new ConsoleView();
    GameManager gm = new GameManager(Config.getCountBall(), cv, cv);
    gm.run();
  }
}
