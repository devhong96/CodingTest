import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        StringTokenizer st;

        int total = Integer.parseInt(br.readLine());
        int[] num = new int[total];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < total; i++)
            num[i] = Integer.parseInt(st.nextToken());

        solution.solution(num);
    }
}

class Solution {
    static int answer = 0;
    static int N;
    static int[] arr;
    static boolean[] visited;
    public void solution(int[] num) {

        N = num.length;
        arr = new int[N];
        visited = new boolean[N];

        permutation(num, 0);
        System.out.print(answer);
    }

    public void permutation(int[] num, int depth){

        if(depth == N){
            int sum = 0;
            for(int i = 0; i < N - 1; i++){
                sum += Math.abs(arr[i + 1] - arr[i]);
            }
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            arr[depth] = num[i];
            visited[i] = true;
            permutation(num, depth + 1);
            visited[i] = false;
        }
    }
}
