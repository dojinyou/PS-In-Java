/**
 * 프로그래머스 / 12948 / 핸드폰 번호 가리기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12948
 * solve: 5분
 */

package programmers.programmers.private2208.week3.test3;

public class Solution1 {
  public String solution(String phoneNumber) {
    return maskingPhoneNumber(phoneNumber);
  }

  private String maskingPhoneNumber(String phoneNumber) {
    StringBuilder sb = new StringBuilder();
    char[] phoneNumberChars = phoneNumber.toCharArray();

    sb.append("*".repeat(phoneNumberChars.length - 4));
    for (int i = 4; i >= 1; i--) {
      sb.append(phoneNumberChars[phoneNumberChars.length - i]);
    }

    return sb.toString();
  }
}
