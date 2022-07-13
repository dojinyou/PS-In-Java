package programmers.programmers.highscorekit.hash;

import java.util.Arrays;

public class PhoneNumberList {
  public boolean solution(String[] phoneBook) {
    Arrays.sort(phoneBook);
    for (int i = 0; i < phoneBook.length-1; i++) {
      if (phoneBook[i+1].startsWith(phoneBook[i])) {
        return false;
      }
    }
    return true;
  }
}
