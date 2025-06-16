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

        int count = 0;
        int number = 0;
        while (true) {
            if (String.valueOf(number).contains("666")) {
                count++;
                if (count == num) {
                    return number;
                }
            }
            number++;
        }
    }
}