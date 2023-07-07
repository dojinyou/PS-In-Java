package problemsolving.devmatching.backend21;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import problemsolving.programmers.devmatching.backend21.ProblemLotto;

class ProblemLottoTest {

  @Test
  void solution() {
     int[][] lottosArray = {
         {44, 1, 0, 0, 31, 25},
         {0, 0, 0, 0, 0, 0},
         {45, 4, 35, 20, 3, 9}
     };
     int[][] winNumbersArray = {
         {31, 10, 45, 1, 6, 19},
         {38, 19, 20, 40, 15, 25},
         {45, 4, 35, 20, 3, 9}
     };
     int[][] resultArray = {
         {3, 5},
         {1, 6},
         {1, 1}
     };

     ProblemLotto pl = new ProblemLotto();
    for (int i = 0; i < lottosArray.length; i++) {
      int[] answer = pl.solution(lottosArray[i], winNumbersArray[i]);
      int[] result = resultArray[i];
      assertArrayEquals(answer, result);
    }
  }
}
