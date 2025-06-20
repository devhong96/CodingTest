import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Solution solution = new Solution();

        st = new StringTokenizer(br.readLine(), " ");

        int total = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        System.out.println(solution.solution(total, k, l));
    }
}

class Solution {
    public int solution(int total, int k, int l) {

        int answer = 0;

        while(k != l) {
            k = (k + 1) / 2;
            l = (l + 1) / 2;
            answer++;
        }
        return answer;
    }
}