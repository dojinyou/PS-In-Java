package leetcode.studyplan.level2.day1;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    private final static int START_X = 0;
    private final static int START_Y = 0;
    private final static Direction START_DIRECTION = Direction.EAST;

    public List<Integer> spiralOrder(int[][] matrix) {
        final int W = matrix.length;
        final int H = matrix[0].length;
        final boolean[][] visited = new boolean[W][H];
        List<Integer> result = new ArrayList<>(W * H);

        var currentX = START_X;
        var currentY = START_Y;
        var currentDirection = START_DIRECTION;

        while(result.size() < W * H) {
            result.add(matrix[currentX][currentY]);
            visited[currentX][currentY] = true;

            int nextX = currentX + currentDirection.x;
            int nextY = currentY + currentDirection.y;

            if(!isValidPoint(visited, nextX, nextY)) {
                currentDirection = Direction.nextDirection(currentDirection);
                nextX = currentX + currentDirection.x;
                nextY = currentY + currentDirection.y;
            }

            currentX = nextX;
            currentY = nextY;
        }

        return result;
    }

    private boolean isValidPoint(boolean[][] visited, int x, int y) {
        var isValidX = 0 <= x && x < visited.length;
        var isValidY = 0 <= y && y < visited[0].length;

        return isValidX && isValidY && !visited[x][y];
    }

    enum Direction {
        EAST(0, 1),
        SOUTH(1, 0),
        WEST(0,-1),
        NORTH(-1, 0),
        ;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
        final int x;
        final int y;

        static final Direction[] VALUES = values();

        public static Direction nextDirection(Direction current) {
            var nextOrdinal = (current.ordinal() + 1) % VALUES.length;

            return VALUES[nextOrdinal];
        }
    }
}
