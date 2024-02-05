import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        solution.solution(num, length);
    }
}

class Solution {
    static boolean[] visited;
    static int[] arr;
    static StringBuilder answer = new StringBuilder();
    public void solution(int num, int length) {

        visited = new boolean[num];
        arr = new int[length];
        permutation(0, num, length);
        System.out.print(answer.toString());
    }

    public void permutation(int depth, int num, int length){
        if(depth == length){
            for(int i = 0; i < length; i++) {
                answer.append(arr[i]).append(' ');
            }
            answer.append('\n');
            return;
        }

        for(int i = 0; i < num; i++){
            if(visited[i]) continue;
            arr[depth] = i + 1;
            visited[i] = true;
            permutation(depth + 1, num, length);
            visited[i] = false;
        }
    }
}
