package problemsolving.baseball;

import java.util.List;

class Sample {

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    // 밸리데이션한다.
    // 비교 결과를 반환한다.
    //

    try {
      Pages pobiPages = Pages.of(pobi);
      Pages crongPages = Pages.of(crong);

      Result result = pobiPages.compareTo(crongPages);
      return result.ordinal();
    } catch (IllegalArgumentException e) {
      return -1;
    }
  }

  static class Pages {
    private static final int SIZE_OF_PAGES = 2;
    private static final int LAST_PAGE_NUMBER = 400;

    private final List<Integer> problems;

    private Pages(List<Integer> problems) {
      this.problems = problems;
    }

    public static Pages of(List<Integer> problems) {
      validate(problems);
      return new Pages(problems);
    }

    private static void validate(List<Integer> problems) {
      validateListSize(problems);
      validateContinuousElement(problems);
      validateFirstOrLastPages(problems);
    }

    private static void validateFirstOrLastPages(List<Integer> problems) {
      if (problems.get(0) == 1 || problems.get(1) == LAST_PAGE_NUMBER) {
        throw new IllegalArgumentException();
      }
    }

    private static void validateListSize(List<Integer> problems) {
      if (problems.size() != SIZE_OF_PAGES) {
        throw  new IllegalArgumentException();
      }
    }

    private static void validateContinuousElement(List<Integer> problems) {
      int leftPageNumber = problems.get(0);
      int rightPageNumber = problems.get(1);

      if (leftPageNumber % 2 == 0 || leftPageNumber + 1 != rightPageNumber) {
        throw  new IllegalArgumentException();
      }
    }

    public Result compareTo(Pages crongPages) {
      return null;
    }
  }

  enum Result {
    WIN,
    DRAW,
    LOSE
  }
}
