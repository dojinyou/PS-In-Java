package leetcode.studyplan.level2.day1;

import java.util.Arrays;

public class WhereWillTheBallFall {

    public int[] findBall(int[][] grid) {
        int countBalls = grid[0].length;
        int[] result = new int[countBalls];

        for (int i = 0; i < countBalls; i++) {
            result[i] = isFall(i, grid);
        }

        return result;
    }

    private int isFall(int startIndex, int[][] grid) {
        System.out.println(startIndex);
        int currentX = 0;
        int currentY = startIndex;

        while (currentX < grid.length) {
            System.out.print("currentX="+currentX);
            System.out.println(" / currentY="+currentY);
            int nextBoardNumber = grid[currentX][currentY];
            Board board = Board.numberOf(nextBoardNumber);
            // 다음으로 갈 수 있다면,
            if (isNotValidPath(currentX, currentY, board, grid)) {
                return -1;
            }

            currentX += 1;
            currentY += board.dy;
        }

        return currentY;
    }

    private boolean isNotValidPath(int currentX, int currentY, Board board, int[][] grid) {
        int nextX = currentX + 1;
        int nextY = currentY + board.dy;
        if (nextY < 0 || grid[currentX].length <= nextY) return true;
        if (board != Board.numberOf(grid[currentX][nextY])) return true;
        if (nextX < grid.length && grid[nextX].length <= nextY) return true;

        return false;
    }

    enum Board {
        RIGHT_BOTTOM(1, 1),
        RIGHT_TOP(-1, -1),
        ;

        private final int number;
        private final int dy;

        Board(int number, int dy) {
            this.number = number;
            this.dy = dy;
        }

        public static Board numberOf(int i) {
            return RIGHT_BOTTOM.number == i ? RIGHT_BOTTOM : RIGHT_TOP;
        }
    }

    public static void main(String[] args) {
        var result = new WhereWillTheBallFall().findBall(new int[][]{
                {1,1,1,-1,-1},
                {1,1,1,-1,-1},
                {-1,-1,-1,1,1},
                {1,1,1,1,-1},
                {-1,-1,-1,-1,-1}
        });

        System.out.println(Arrays.toString(result));
    }
}
