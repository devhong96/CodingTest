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

        System.out.println(solution.solution(st.nextToken(), st.nextToken()));
    }
}

class Solution {
    public int solution(String str1, String str2) {

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i <= str2.length() - str1.length(); i++) {
            int diff = 0;
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) != str2.charAt(i + j)) {
                    diff++;
                }
            }
            answer = Math.min(answer, diff);
        }

        return answer;
    }
}