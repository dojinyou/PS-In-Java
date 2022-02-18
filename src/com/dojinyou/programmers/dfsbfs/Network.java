// 프로그래머스 : 코딩테스트 연습 > 깊이/너비 우선 탐색(BFS/DFS) > 네트워크
// 관련 링크 : https://programmers.co.kr/learn/courses/30/lessons/43162?language=java

class Network {
    public int solution(int n, int[][] computers) {
        boolean[] isVisited = new boolean[computers.length];
        int answer = 0;
        for (int from = 0; from < computers.length; from++) {
            if (!isVisited[from]) {
                answer++;
                dfs(from, computers, isVisited);
            }
        }
        return answer;
    }

    public void dfs(int from, int[][] computers, boolean[] isVisited) {
        isVisited[from] = true;
        for (int to = 0; to < computers.length; to++) {
            if (computers[from][to] == 1 && !isVisited[to]) {
                dfs(to, computers, isVisited);
            }
        }
    }
}