public class Solution {

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        compress(arr, 0, 0, arr.length, answer);
        return answer;
    }

    private void compress(int[][] arr, int x, int y, int n, int[] answer) {
        // Base case: 영역 내의 모든 수가 같은 경우
        if (checkUniform(arr, x, y, n)) {
            answer[arr[x][y]]++;
            return;
        }

        // 4분할하여 각 영역에 대해 압축 수행
        int half = n / 2;
        compress(arr, x, y, half, answer);
        compress(arr, x, y + half, half, answer);
        compress(arr, x + half, y, half, answer);
        compress(arr, x + half, y + half, half, answer);
    }

    private boolean checkUniform(int[][] arr, int x, int y, int n) {
        int value = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}