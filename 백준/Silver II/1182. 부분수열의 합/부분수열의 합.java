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
        int[] arr = new int[count];
        int sum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution.solution(sum, arr);

    }
}

class Solution {
    static int[] arr;
    static int target;
    static int answer = 0;
    public void solution(int sum, int[] num) {
        arr = num;
        target = sum;
        dfs(0, 0);
        if(target == 0) {
            System.out.print(answer - 1);
        }else{
            System.out.print(answer);
        }
    }
    public void dfs(int depth, int sum){
        if(depth == arr.length){
            if(sum == target) answer++;
            return;
        }
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}
