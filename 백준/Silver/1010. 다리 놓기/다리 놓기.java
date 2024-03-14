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
        int count = Integer.parseInt(st.nextToken());
        for(int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            solution.solution(n, k);
        }
    }
}

class Solution {
    public void solution(int n, int k) {
        long[][] dy = new long[31][31];
        for(int x = 0; x <= 30; x++){
            dy[x][1] = x;
            dy[x][0] = 1;
            dy[x][x] = 1;
        }

        for(int y = 2; y <= 30; y++){
            for(int x = 1; x <= 30; x++){
                dy[y][x] = dy[y - 1][x] + dy[y - 1][x - 1];
            }
        }
        System.out.println(dy[k][n]);
    }
}