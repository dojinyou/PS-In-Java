import java.util.*;

// progammers - 코딩테스트연습 > 해시 > 완주하지 못한 선수
// 관련 링크 (https://programmers.co.kr/learn/courses/30/lessons/42576?language=java)

class UnCompletedRunner {
    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String participant: participants) {
            if (!map.containsKey(participant)) {
                map.put(participant,0);
            }
            map.put(participant, map.get(participant)+1);
        }

        for (String completion: completions) {
            int numOfCompletion = map.get(completion);
            if (numOfCompletion == 1) {
                map.remove(completion);
            } else {
                map.put(completion, numOfCompletion - 1);
            }
        }
        // String[] results = map.keySet().toArray(new String[map.size()]);
        ArrayList<String> results = new ArrayList<String>(map.keySet());
        return results.get(0);
    }
}