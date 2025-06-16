import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Solution solution = new Solution();

        int num = Integer.parseInt(br.readLine());
        System.out.println(solution.solution(num));
    }
}


class Solution {
    public int solution(int num) {

        int answer;

        if(num < 100){
            answer = num;
        } else {
            answer = 99;
            for (int i = 100; i <= num; i++) {

                int a = i / 100;
                int b = i / 10 % 10;
                int c = i % 10;
                if (a + c == 2 * b) {
                    answer++;
                }
            }
        }

        return answer;
    }
}