package programmers.programmers.highscorekit.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberOfK {

  private static final int START_IDX_COMMAND_IDX = 0;
  private static final int END_IDX_COMMAND_IDX = 1;
  private static final int FIND_IDX_COMMAND_IDX = 2;

  public int[] solution(
      int[] array,
      int[][] commands
  ) {
    int[] result = new int[commands.length];

    for (int i = 0; i < commands.length; i++) {
      int[] command = commands[i];

      int startIdx = command[START_IDX_COMMAND_IDX] - 1;
      int endIdx = command[END_IDX_COMMAND_IDX];
      int findIdx = command[FIND_IDX_COMMAND_IDX] - 1;

      AtomicInteger idx = new AtomicInteger();

      result[i] = Arrays
          .stream(array, startIdx, endIdx)
          .sorted()
          .filter(value -> idx.getAndIncrement() == findIdx)
          .sum();
    }

    return result;
  }

  private static void print(int[] slice1) {
    for (int a : slice1) {
      System.out.print(a + " -> ");
    }
    System.out.println();
  }

  private int[] nativeSlice(
      int[] arr,
      int startIdx,
      int endIdx
  ) {
    int[] slice = new int[endIdx - startIdx];

    if (endIdx - startIdx >= 0) {
      System.arraycopy(arr, startIdx, slice, 0, endIdx - startIdx);
    }

    return slice;
  }

  private int[] ArraysSlice(
      int[] arr,
      int startIdx,
      int endIdx
  ) {
    return Arrays.copyOfRange(arr, startIdx, endIdx);
  }

  private int[] streamSlice(
      int[] arr,
      int startIdx,
      int endIdx
  ) {
    return Arrays
        .stream(arr, startIdx, endIdx)
        .toArray();
  }
}
