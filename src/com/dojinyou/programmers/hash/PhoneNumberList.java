import java.util.Arrays;

// 프로그래머스 : 코딩테스트 연습 > 해시 > 전화번호 목록
// 관련 링크 : https://programmers.co.kr/learn/courses/30/lessons/42577

class PhoneNumberList {
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