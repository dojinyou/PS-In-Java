// 프로그래머스 : 코딩테스트 연습 > 깊이/너비 우선 탐색(BFS/DFS) > 타겟 넘버
// 관련 링크 : https://programmers.co.kr/learn/courses/30/lessons/43165?language=java


class TargetNumber {
    public int solution(int[] numbers, int target) {
        return dfs(0,0,numbers,target);
    }

    public int dfs(int num, int sum, int[] numbers, int TARGET) {
        int nextSum1 = sum + numbers[num];
        int nextSum2 = sum - numbers[num];

        if (num+1==numbers.length) {
            if (nextSum1 == TARGET || nextSum2 == TARGET) {return 1;}
            return 0;
        }
        return dfs(num+1, nextSum1,numbers,TARGET) + dfs(num+1, nextSum2,numbers,TARGET);
    }
}