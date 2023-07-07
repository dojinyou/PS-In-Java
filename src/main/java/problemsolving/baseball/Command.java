package problemsolving.baseball;

public enum Command {
  CONTINUE("1"),
  STOP("2");

  private final String commandString;

  Command(String commandString) {
    this.commandString = commandString;
  }

  public static Command of(String input) {
    for (Command command: values()) {
      if (command.commandString.equals(input)) {
        return command;
      }
    }
    throw new IllegalArgumentException();
  }
}
