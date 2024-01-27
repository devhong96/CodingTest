import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Solution solution = new Solution();

        int num = Integer.parseInt(br.readLine());

        solution.solution(num);
    }
}

class Solution {
    static int N;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public void solution(int num) {
        visited = new boolean[num];
        arr = new int[num];
        N = num;

        permutation(0, num);
        System.out.println(sb);
    }

    public void permutation(int depth, int target){

        if(depth == N){
            for(int i = 0; i < N; i++)
                sb.append(arr[i] + " ");

            sb.append('\n');
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i])
                continue;
            arr[depth] = i + 1;
            visited[i] = true;
            permutation(depth + 1, target);
            visited[i] = false;
        }
    }
}