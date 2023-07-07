package problemsolving.programmers.private2208.week2.test1;

import java.util.ArrayList;
import java.util.List;

public class SRLMirror {

  private Mirror[][] mirrorMatrix;

  public int[] solution(String[] grid) {
    init(grid);

    return findAllCycleWithLength();
  }

  private int[] findAllCycleWithLength() {
    List<Integer> result = new ArrayList<>();

    Mirror mirror;
    while ((mirror = findNotVisitedMirror()) != null) {
      Mirror.Direction direction = mirror.getNotVisitedDirection();

      int cycleLength = mirror.inLight(direction);

      result.add(cycleLength);
    }

    return result
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }

  private Mirror findNotVisitedMirror() {
    for (int i = 0; i < mirrorMatrix.length; i++) {
      for (int j = 0; j < mirrorMatrix[0].length; j++) {
        if (!mirrorMatrix[i][j].isCompleted()) {
          return mirrorMatrix[i][j];
        }
      }
    }
    return null;
  }

  private void init(String[] grid) {
    int xSize = grid.length;
    int ySize = grid[0].length();
    mirrorMatrix = new Mirror[xSize][ySize];

    for (int i = 0; i < xSize; i++) {
      char[] types = grid[i].toCharArray();
      for (int j = 0; j < ySize; j++) {
        mirrorMatrix[i][j] = new Mirror(i, j, types[j]);
      }
    }

    for (int i = 0; i < xSize; i++) {
      for (int j = 0; j < ySize; j++) {
        for (Mirror.Direction direction : Mirror.Direction.values()) {
          int nextX = (i + direction.xSalt + xSize) % xSize;
          int nextY = (j + direction.ySalt + ySize) % ySize;
          mirrorMatrix[i][j].addNearMirror(direction, mirrorMatrix[nextX][nextY]);
        }
      }
    }
  }
}

class Mirror {
  final int x;
  final int y;
  final char type;

  int isCompleted = 0;

  final boolean[] isVisited = new boolean[Direction.values().length];
  Mirror[] nearMirrors = new Mirror[Direction.values().length];

  Mirror(
      int x,
      int y,
      char type
  ) {
    this.x = x;
    this.y = y;
    this.type = type;
  }

  void addNearMirror(
      Direction direction,
      Mirror mirror
  ) {
    nearMirrors[direction.ordinal()] = mirror;
  }

  int inLight(Direction direction) {
    if (isVisited[direction.ordinal()]) {
      return 0;
    }

    isVisited[direction.ordinal()] = true;
    isCompleted++;

    Direction changedDirection = changeDirection(direction);

    return nearMirrors[changedDirection.ordinal()].inLight(changedDirection) + 1;
  }

  private Direction changeDirection(Direction direction) {
    int salt = 0;
    if (type == 'R') {
      salt++;
    } else if (type == 'L') {
      salt--;
    }

    int directionIdx =
        (direction.ordinal() + salt + Direction.values().length) % Direction.values().length;

    return Direction.values()[directionIdx];
  }

  public Direction getNotVisitedDirection() {
    for (Direction direction : Direction.values()) {
      if (!isVisited[direction.ordinal()]) {
        return direction;
      }
    }
    return null;
  }

  public boolean isCompleted() {
    return isCompleted == 4;
  }

  enum Direction {
    TOP(1, 0),
    RIGHT(0, 1),
    BOTTOM(-1, 0),
    LEFT(0, -1),
    ;

    final int xSalt;
    final int ySalt;

    Direction(
        int xSalt,
        int ySalt
    ) {
      this.xSalt = xSalt;
      this.ySalt = ySalt;
    }
  }
}
