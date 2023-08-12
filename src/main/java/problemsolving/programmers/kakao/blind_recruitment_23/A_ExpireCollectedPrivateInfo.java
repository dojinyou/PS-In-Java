package problemsolving.programmers.kakao.blind_recruitment_23;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A_ExpireCollectedPrivateInfo {

  private static final String TEMRS_SEPARATOR = " ";
  private static final String PRIVACY_SEPARATOR = " ";
  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

  /**
   * 고객의 약관 동의를 얻어서 수집된 1~n번으로 분류되는 개인정보 n개가 있습니다. 약관 종류는 여러 가지 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다.
   * 당신은 각 개인정보가 어떤 약관으로 수집됐는지 알고 있습니다. 수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다. 예를 들어,
   * A라는 약관의 유효기간이 12 달이고, 2021년 1월 5일에 수집된 개인정보가 A약관으로 수집되었다면 해당 개인정보는 2022년 1월 4일까지 보관 가능하며 2022년
   * 1월 5일부터 파기해야 할 개인정보입니다. 당신은 오늘 날짜로 파기해야 할 개인정보 번호들을 구하려 합니다.
   *
   * @param todayString 날짜를 의미하는 문자열(YYYY.MM.DD)
   * @param terms       약관의 유효기간을 담을 1차원 String[] ("약관종류 유효기간" 형태, 1 <= length <= 20, 약관의 종류는 A ~
   *                    Z)
   * @param privacies   수집된 개인정보를 담은 1차원 String[] ("날짜 약관종류" 형태, 날짜는 today 이전만 있음)
   * @return 번호의 오름차순으로 정렬된 파기해야될 개인정보 int[]
   */
  public int[] solution(String todayString, String[] terms, String[] privacies) {
    List<Integer> result = new ArrayList<>(privacies.length);
    Map<String, Long> termsMap = new HashMap<>(terms.length);
    for (String termString : terms) {
      String[] splitedTermString = termString.split(TEMRS_SEPARATOR);
      String termName = splitedTermString[0];
      Long validMonth = Long.valueOf(splitedTermString[1]);
      termsMap.put(termName, validMonth);
    }

    LocalDate today = LocalDate.parse(todayString, DATE_FORMATTER);
    for (int i = 0; i < privacies.length; i++) {
      String[] splitedPrivacy = privacies[i].split(PRIVACY_SEPARATOR);
      String termName = splitedPrivacy[1];
      long validMonth = termsMap.getOrDefault(termName, 0L);
      LocalDate expiredDate = LocalDate.parse(splitedPrivacy[0], DATE_FORMATTER)
          .plusMonths(validMonth);
      if (today.isAfter(expiredDate)) {
        result.add(i + 1);
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }

}
