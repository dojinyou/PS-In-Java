package programmers.programmers.private2208.week2.test2;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class EditTableRefactoringTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          Arguments.of(new ProgrammersTestData(8,2,new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}, "OOOOXOOO")),
          Arguments.of(new ProgrammersTestData(8,2,new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}, "OOXOXOOO"))
      );
    }
  }

  static class ProgrammersTestData {
    private final int n;

    private final int k;

    private final String[] cmd;

    private final String results;

    ProgrammersTestData(
        int n,
        int k,
        String[] cmd,
        String results
    ) {
      this.n = n;
      this.k = k;
      this.cmd = cmd;
      this.results = results;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {

    var testClass = new EditTableRefactoring();
    String actual = testClass.solution(data.n, data.k, data.cmd);

    assertThat(actual).isEqualTo(data.results);
  }

}
