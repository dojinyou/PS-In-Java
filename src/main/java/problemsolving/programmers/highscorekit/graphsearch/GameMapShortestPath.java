package problemsolving.programmers.highscorekit.graphsearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1844
 *
 * 게임 맵의 상태 maps가 매개변수로 주어질 때,
 * 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
 * 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
 *
 * 제한사항
 * - maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
 *    - n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
 * - maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
 * - 처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
 */

public class GameMapShortestPath {

    private static final int IMPOSSIBLE_MOVE = -1;
    private static final int LOCK = 0;
    private static final int PATH = 1;
    private static final int START_X = 0;
    private static final int START_Y = 0;


    public int solution(int[][] maps) {
        final int maxX = maps.length - 1;
        final int maxY = maps[0].length - 1;
        final Direction[] allDirections = Direction.values();
        boolean[][] visitedMap = new boolean[maxX + 1][maxY + 1];
        int minMove = IMPOSSIBLE_MOVE;

        SearchLocation startingSearchLocation = new SearchLocation(START_X, START_Y, 1);
        Queue<SearchLocation> searchSearchLocationQueue = new LinkedList<>();

        searchSearchLocationQueue.add(startingSearchLocation);
        visitedMap[startingSearchLocation.x][startingSearchLocation.y] = true;

        while(!searchSearchLocationQueue.isEmpty()) {
            var currentLocation = searchSearchLocationQueue.poll();
            System.out.println("x = "+currentLocation.x+", y = "+currentLocation.y);
            if (currentLocation.x == maxX && currentLocation.y == maxY) {
                minMove = currentLocation.moveCount;
                break;
            }

            for (Direction direction: allDirections) {
                int nextX = currentLocation.x + direction.dx;
                int nextY = currentLocation.y + direction.dy;

                // 범위 체크
                if (nextX < 0 || maxX < nextX || nextY < 0 || maxY < nextY) {
                    continue;
                }

                // 이동 가능여부 체크
                boolean isVisited = visitedMap[nextX][nextY];
                boolean isLock = maps[nextX][nextY] == LOCK;
                if (isVisited || isLock) {
                    continue;
                }

                var nextLocation = new SearchLocation(nextX, nextY, currentLocation.moveCount + 1);
                searchSearchLocationQueue.add(nextLocation);
                visitedMap[nextLocation.x][nextLocation.y] = true;
            }
        }

        return minMove;
    }

    private class SearchLocation {
        final int x;
        final int y;
        final int moveCount;

        private SearchLocation(int x, int y, int moveCount) {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
        }
    }

    enum Direction {
        SOUTH(1, 0),
        EAST(0, 1),
        NORTH(-1, 0),
        WEST(0, -1),
        ;

        final int dx;
        final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

}
