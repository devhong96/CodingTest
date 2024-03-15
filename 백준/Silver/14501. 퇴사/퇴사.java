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
        int[][] arr = new int[2][count];
        for(int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }
        solution.solution(arr);
    }
}

class Solution {
    public void solution(int[][] arr) {
        int N = arr[0].length;
        int[] M = new int[N + 1];

        for(int i = N - 1; i >= 0; i--){
            if (arr[0][i] + i > N) {
                M[i] = M[i + 1];
            } else {
                M[i] = Math.max(M[i + 1], M[i + arr[0][i]] + arr[1][i]);
            }
        }
        System.out.println(M[0]);
    }
}