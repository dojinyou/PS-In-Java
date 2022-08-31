package programmers.programmers.private2208.week2;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import programmers.programmers.private2208.week2.BrokenBuilding;

class BrokenBuildingTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(Arguments.of(new ProgrammersTestData(new int[][]{
                           {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}
                       }, new int[][]{
                           {1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}
                       }, 10)),
                       Arguments.of(new ProgrammersTestData(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                                                            new int[][]{
                                                                {1, 1, 1, 2, 2, 4},
                                                                {1, 0, 0, 1, 1, 2},
                                                                {2, 2, 0, 2, 0, 100}
                                                            },
                                                            6
                       )));
    }

    static class ProgrammersTestData {
      private final int[][] board;

      private final int[][] skill;

      private final int results;

      ProgrammersTestData(
          int[][] board,
          int[][] skill,
          int results
      ) {
        this.board = board;
        this.skill = skill;
        this.results = results;
      }

    }

    @ParameterizedTest
    @ArgumentsSource(DataArguments.class)
    void test(ProgrammersTestData data) {

      var testClass = new BrokenBuilding();
      int actual = testClass.solution(data.board, data.skill);

      assertThat(actual).isEqualTo(data.results);
    }
  }
}
