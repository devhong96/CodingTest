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

        System.out.println(solution.solution(num));
    }
}

class Solution {
    int[] arr, ans;
    int length, answer = 0;
    boolean[] visited;
    public int solution(int[] num) {

        arr = num;
        length = num.length;
        ans = new int[length];
        visited = new boolean[length];

        permutation(0);

        return answer;
    }

    private void permutation(int depth) {

        if(depth == length){
            int sum = 0;
            for (int i = 1; i < length; i++) {
                sum += Math.abs(ans[i - 1] - ans[i]);
            }
            answer = Math.max(sum, answer);
            return;
        }

        for (int i = 0; i < length; i++) {
            if(visited[i]) continue;
            ans[depth] = arr[i];
            visited[i] = true;
            permutation(depth + 1);
            visited[i] = false;
        }
    }
}
