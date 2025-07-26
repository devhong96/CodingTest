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

        int[] budget = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            budget[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(solution.solution(M, budget));
    }
}

class Solution {
    public int solution(int M, int[] budgets) {

        Arrays.sort(budgets);

        int answer = 0;

        int lt = 0, rt = budgets[budgets.length - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int sum = 0;

            for (int budget : budgets) {
                sum += Math.min(mid, budget);
            }

            if (sum <= M) {
                lt = mid + 1;
                answer = mid;
            } else {
                rt = mid - 1;
            }
        }

        return answer;
    }
}