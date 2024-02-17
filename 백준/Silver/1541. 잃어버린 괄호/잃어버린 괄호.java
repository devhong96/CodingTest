import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();

        String str = br.readLine();
        solution.solution(str);
    }
}

class Solution {
    public void solution(String str) {
        int answer = MAX_VALUE;
        StringTokenizer st = new StringTokenizer(str, "-");

        while (st.hasMoreTokens()) {
            int temp = 0;
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
            while (st2.hasMoreTokens()) {
                temp += Integer.parseInt(st2.nextToken());
            }

            if(answer == MAX_VALUE) {
                answer = temp;
            }else{
                answer-=temp;
            }
        }
        System.out.println(answer);
    }
}
