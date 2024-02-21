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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution.solution(N, M, arr);
    }
}

class Solution {
    static int[] arr2;
    static boolean[] visited;
    static int total, length;
    static StringBuilder answer = new StringBuilder();
    public void solution(int N, int M, int[] arr) {
        total = N;
        length = M;

        arr2 = new int[length];
        visited = new boolean[total];

        Arrays.sort(arr);
        permutation(0, arr);
        System.out.print(answer.toString());
    }

    public void permutation(int depth, int[] arr){
        if(depth == length){
            for(int i = 0; i < length; i++){
                answer.append(arr2[i]).append(' ');
            }
            answer.append('\n');
            return;
        }

        for(int i = 0; i < total; i++){
            arr2[depth] = arr[i];
            permutation(depth + 1, arr);
        }
    }
}
