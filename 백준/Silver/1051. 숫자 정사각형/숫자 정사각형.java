import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Solution solution = new Solution();

        st = new StringTokenizer(br.readLine(), " ");

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] arr = new int[h][w];

        for (int y = 0; y < h; y++) {
            String str = br.readLine();
            for (int x = 0; x < w; x++) {
                arr[y][x] = Integer.parseInt(String.valueOf(str.charAt(x)));
            }
        }

        System.out.println(solution.solution(arr));
    }
}

class Solution {
    public int solution(int[][] arr) {

        int answer = 1;
        int height = arr.length;
        int width = arr[0].length;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                for (int k = 1; y + k < height && x + k < width; k++) {
                    if (arr[y + k][x + k] == arr[y + k][x]
                            && arr[y][x] == arr[y][x + k] && arr[y + k][x + k] == arr[y][x]) {
                        answer = Math.max(k + 1, answer);
                    }
                }
            }
        }

        return answer * answer;
    }
}