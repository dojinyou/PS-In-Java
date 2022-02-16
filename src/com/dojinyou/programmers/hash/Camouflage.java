import java.util.*;

// 프로그래머스 : 코딩테스트 연습 > 해시 > 위장
// 관련 링크 :https://programmers.co.kr/learn/courses/30/lessons/42578 

class Camouflage {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String[] cloth:clothes) {
            String clothType = cloth[1];

            map.put(clothType, map.getOrDefault(clothType, 0)+1);
        }

        Collection<Integer> clothArray = map.values();

        int answer = 1;
        for (int numOfCloth : clothArray) {
            answer = answer * (numOfCloth + 1);
        }
        return answer - 1 ;
    }
}