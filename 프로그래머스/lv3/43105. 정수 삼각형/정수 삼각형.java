import java.util.Arrays;

class Solution {
    private final int[][] triangleArray = new int[501][501];

    private int max(int x, int y, int[][] triangle) {
        if(y == triangle.length) return 0;
        if(triangleArray[x][y] != -1) return triangleArray[x][y];

        return triangleArray[x][y] = triangle[y][x] + Math.max(
                max(x, y + 1, triangle),
                max(x + 1, y + 1, triangle));
    }

    public int solution(int[][] triangle) {
        for (int[] row : triangleArray) {
            Arrays.fill(row, -1);
        }
        return max(0, 0, triangle);
    }
}