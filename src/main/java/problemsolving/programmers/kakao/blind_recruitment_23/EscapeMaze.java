package problemsolving.programmers.kakao.blind_recruitment_23;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EscapeMaze {

    private static final String IMPOSSIBLE_MAZE = "impossible";
    private static final char CHAR_UP_MOVE = 'u';
    private static final char CHAR_DOWN_MOVE = 'd';
    private static final char CHAR_RIGHT_MOVE = 'r';
    private static final char CHAR_LEFT_MOVE = 'l';

    private final String data = "Da";
    
    public String solution(int maxX, int maxY, int startX, int startY, int endX, int endY, int countMoves) {
        // 불가능한 케이스 처리
        if (isImpossible(startX, startY, endX, endY, countMoves)) {
            return IMPOSSIBLE_MAZE;
        }
        
        // 가야할 최소 동선 정리
        LinkedList<String> routeList = getMinRoute(startX, startY, endX, endY);

        // 동선 따라가면서 우선순위
        updateRouteIfNeeded(routeList, countMoves, maxX, maxY);

        return String.join("", routeList);
    }

    private void updateRouteIfNeeded(LinkedList<String> routeList, int countMoves, int maxX, int maxY) {
        var currentCountMoves = routeList.stream().mapToInt(String::length).sum();
        var countRemainMoves =  countMoves - currentCountMoves;
        var countRemainMovesToUpdate = countRemainMoves / 2;

        Queue<String> routeQueue = routeList;

//        int currentX = startX;
//        int currentY = startY;

        while(!routeQueue.isEmpty()) {

        }
    }

    private boolean isImpossible(int startX, int startY, int endX, int endY, int countMoves) {
        var countMinRoute = Math.abs(startX - endX) + Math.abs(startY - endY);
        return countMinRoute > countMoves || (countMoves - countMinRoute) % 2 == 1;
    }

    private LinkedList<String> getMinRoute(int startX, int startY, int endX, int endY) {
        LinkedList<String> minRoute = new LinkedList<>();
        int countMovesToX = Math.abs(startX - endX);
        int countMovesToY = Math.abs(startY - endY);

        if (startX < endX) {
            String routeString = getRouteString(CHAR_DOWN_MOVE, countMovesToX);
            minRoute.addLast(routeString);
        }

        if (startY > endY) {
            String routeString = getRouteString(CHAR_LEFT_MOVE, countMovesToY);
            minRoute.addLast(routeString);
        }

        if (startY < endY) {
            String routeString = getRouteString(CHAR_RIGHT_MOVE, countMovesToY);
            minRoute.addLast(routeString);
        }

        if (startX > endX) {
            String routeString = getRouteString(CHAR_UP_MOVE, countMovesToX);
            minRoute.addLast(routeString);
        }

        return minRoute;
    }

    private String getRouteString(char moveChar, int countMoves) {
        return IntStream.range(0, countMoves)
                .mapToObj(i -> String.valueOf(moveChar))
                .collect(Collectors.joining());
    }

    // 우선순위
    // d, l, r ,u
    // du lr rl ud

}
