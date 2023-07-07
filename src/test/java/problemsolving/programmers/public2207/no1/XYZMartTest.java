package problemsolving.programmers.public2207.no1;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class XYZMartTest {
  static class DataArguments implements ArgumentsProvider {

    @Override
    public Stream<Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(Arguments.of(new ProgrammersTestData(new String[]{
                           "banana", "apple", "rice", "pork", "pot"
                       }, new int[]{3, 2, 2, 2, 1}, new String[]{
                           "chicken",
                           "apple",
                           "apple",
                           "banana",
                           "rice",
                           "apple",
                           "pork",
                           "banana",
                           "pork",
                           "rice",
                           "pot",
                           "banana",
                           "apple",
                           "banana"
                       }, 3)),
                       Arguments.of(new ProgrammersTestData(new String[]{"apple"},
                                                            new int[]{10},
                                                            new String[]{
                                                                "banana",
                                                                "banana",
                                                                "banana",
                                                                "banana",
                                                                "banana",
                                                                "banana",
                                                                "banana",
                                                                "banana",
                                                                "banana",
                                                                "banana"
                                                            },
                                                            0
                       ))
      );
    }
  }

  static class ProgrammersTestData {
    private final String[] want;

    private final int[] number;

    private final String[] discount;

    private final int results;

    ProgrammersTestData(
        String[] want,
        int[] number,
        String[] discount,
        int results
    ) {
      this.want = want;
      this.number = number;
      this.discount = discount;
      this.results = results;
    }

    public String[] getWant() {
      return want;
    }

    public int[] getNumber() {
      return number;
    }

    public String[] getDiscount() {
      return discount;
    }

    public int getResults() {
      return results;
    }
  }

  @ParameterizedTest
  @ArgumentsSource(DataArguments.class)
  void test(ProgrammersTestData data) {
    String[] want = data.getWant();
    int[] number = data.getNumber();
    String[] discount = data.getDiscount();
    int expect = data.getResults();

    var testClass = new XYZMart();
    int actual = testClass.solution(want, number, discount);

    assertThat(actual).isEqualTo(expect);
  }
}
