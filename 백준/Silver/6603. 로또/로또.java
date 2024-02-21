import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        StringTokenizer st;

        while(true){

            st = new StringTokenizer(br.readLine());

            int total = Integer.parseInt(st.nextToken());
            if(total == 0) break;

            int[] num = new int[total];
            for(int i = 0; i < total; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            solution.solution(num);
        }
    }
}

class Solution {

    static int len = 0;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public void solution(int[] num) {

        sb = new StringBuilder();
        Arrays.sort(num);
        len = num.length;
        visited = new boolean[len];
        arr = new int[6];

        permutation(0, 0, num);

        System.out.println(sb);
    }

    public void permutation(int start, int depth, int[] num) {
        if(depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = start; i < len; i++){
            if(visited[i]) continue;
            arr[depth] = num[i];
            visited[i] = true;
            permutation(i + 1,depth + 1, num);
            visited[i] = false;
        }
    }
}
