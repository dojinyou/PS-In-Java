package problemsolving.baseball;

import java.util.Scanner;

public class ConsoleView implements InputView, OutputView {

  private static final Scanner sc = new Scanner(System.in);

  @Override
  public String inputCommand() {
    return sc.nextLine();
  }

  @Override
  public void display(String message) {
    System.out.println(message);
  }
}
