import java.util.Set;
import java.util.HashSet;

// 프로그래머스 : 코딩테스트 연습 > 동적계획법 > N으로 표현
// 관련 링크 : https://programmers.co.kr/learn/courses/30/lessons/42895?language=java

class Solution {
    public int solution(int N, int target) {
        Set<Integer>[] dp = new Set[9];
        int basicNumber = N;
        for (int i=1;i<9;i++) {
            dp[i] = new HashSet<Integer>();
            dp[i].add(basicNumber);
            basicNumber = basicNumber * 10 + N;
        }
        for (int i=1;i<9;i++) {
            for (Integer numberI : dp[i]) {
                if (numberI == target) {return i;}
                for (int j=1;i+j<9;j++) {
                    Set<Integer> otherSet = dp[i+j];
                    for (Integer numberJ : dp[j]) {
                        otherSet.add(numberI + numberJ);
                        otherSet.add(numberI - numberJ);
                        otherSet.add(numberJ - numberI);
                        otherSet.add(numberI * numberJ);
                        if (numberJ != 0) {
                            otherSet.add(numberI / numberJ);
                        }
                        if (numberI != 0) {
                            otherSet.add(numberJ / numberI);
                        }
                    }
                }
            }
        }
        return -1;
    }
}