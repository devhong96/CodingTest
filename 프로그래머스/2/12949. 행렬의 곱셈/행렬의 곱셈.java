import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int rowA = arr1.length;
        int colA = arr1[0].length;
        int colB = arr2[0].length;

        int[][] answer = new int[rowA][colB];

        for(int y = 0; y < rowA; y++) {
            for(int x = 0; x < colB; x++) {
                for (int i = 0; i < colA; i++) {
                    answer[y][x] += arr1[y][i] * arr2[i][x];
                }
            }
        }

        return answer;
    }
}