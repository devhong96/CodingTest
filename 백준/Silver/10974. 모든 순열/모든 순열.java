import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();

        int num = Integer.parseInt(br.readLine());

        System.out.println(solution.solution(num));
    }
}

class Solution {
    boolean[] visited;
    int[] arr;
    int length;
    StringBuilder sb = new StringBuilder();
    public String solution(int num) {

        visited = new boolean[num];
        arr = new int[num];
        length = num;

        bfs(0);
        return sb.toString();
    }

    private void bfs(int depth) {

        if (depth == length) {
            for (int i = 0; i < length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i < length; i++){
            if(visited[i]) continue;
            arr[depth] = i + 1;
            visited[i] = true;
            bfs(depth + 1);
            visited[i] = false;
        }
    }
}
