package problemsolving.programmers.private2208.week2.test2;

import java.util.ArrayDeque;
import java.util.Deque;

public class EditTableRefactoring {
  /**
   * 명령어에 따른 표 편집
   * 명령어 :
   *    "U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
   *    "D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
   *    "C"  : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다.
   *           단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
   *    "Z"  : 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
   * @param n: 표의 행의 개수, size 5 <= n <= 1,000,000
   * @param k: 처음 선택된 행, size 0 <= k <= n
   * @param cmd: 명령어들이 담긴 문자열 배열, size 1 <= cmd.length <= 200,000
   * @return result: 처음 상태와 나중 상태를 비교하여 삭제 되지 않는 행 => O, 삭제된 행은 X;
   */

  private int currentRow;
  private boolean[] isChangedTable;
  private final Deque<Integer> deletedElement = new ArrayDeque<>();

  public String solution(
      int numOfTableRows,
      int currentRow,
      String[] commands
  ) {
    initTable(numOfTableRows, currentRow);

    executeCommand(commands);

    return getResult();
  }

  private void initTable(
      int numOfTableRows,
      int currentRow
  ) {
    this.isChangedTable = new boolean[numOfTableRows];
    this.currentRow = currentRow;
  }

  private void executeCommand(String[] inputCommands) {
    for (String inputCommand : inputCommands) {
      execute(inputCommand);
    }
  }

  private void execute(String inputCommand) {
    String[] splitedCommand = inputCommand.split(" ");

    switch (splitedCommand[0]) {
      case "U":
        for (int i = 0; i < Integer.parseInt(splitedCommand[1]); i++) {
          moveUp();
        }
        return;
      case "D":
        for (int i = 0; i < Integer.parseInt(splitedCommand[1]); i++) {
          moveDown();
        }
        return;
      case "C":
        isChangedTable[currentRow] = true;
        deletedElement.push(currentRow);
        nextRow();
        return;
      case "Z":
        int lastDeletedRow = deletedElement.pop();
        isChangedTable[lastDeletedRow] = false;
    }
  }

  private void nextRow() {
    if (moveDown()) {
      return;
    }
    moveUp();
  }

  private void moveUp() {
    while(0 <= currentRow - 1) {
      currentRow--;
      if (!isChangedTable[currentRow]) {
        break;
      }
    }
  }

  private boolean moveDown() {
    while(currentRow + 1 < isChangedTable.length) {
      currentRow++;
      if (!isChangedTable[currentRow]) {
        return true;
      }
    }
    return false;
  }

  private String getResult() {
    StringBuilder sb = new StringBuilder();

    int prev = -1;
    for (int i = 0; i < isChangedTable.length; i++) {
      if (isChangedTable[i]) {
        sb.append("O".repeat(i - prev - 1));
        sb.append('X');
        prev = i;
      }
    }
    sb.append("O".repeat(isChangedTable.length - prev - 1));

    return sb.toString();
  }
}
