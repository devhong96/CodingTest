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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        solution.solution(N, M);
    }
}

class Solution {
    static int[] arr;
    static int num, length;
    static StringBuilder answer = new StringBuilder();
    public void solution(int N, int M) {
        num = N;
        length = M;

        arr = new int[length];

        permutation(1,0);
        System.out.print(answer.toString());
    }

    public void permutation(int start, int depth){
        if(depth == length){
            for(int i = 0; i < length; i++) {
                answer.append(arr[i]).append(' ');
            }
            answer.append('\n');
            return;
        }

        for(int i = start; i <= num; i++){
            arr[depth] = i;
            permutation(i + 1,depth + 1);
        }
    }
}
