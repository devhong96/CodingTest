import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        solution.solution(n, k);
    }
}

class Solution {
    public void solution(int n, int k) {
        int[][] dy = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            dy[i][0] = 1;
            dy[i][1] = i;
            dy[i][i] = 1;
        }

        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                dy[i][j] = dy[i - 1][j - 1] + dy[i - 1][j];
            }
        }
        System.out.println(dy[n][k]);
    }
}