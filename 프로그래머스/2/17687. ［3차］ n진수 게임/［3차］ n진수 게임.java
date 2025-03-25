import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {

        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int digit = 0;
        while(sb.length() <= t * m){
            String num = Integer.toString(digit++, n).toUpperCase();
            sb.append(num);
        }

        for (int i = 0; i < t; i++) {
            answer.append(sb.charAt((p - 1) + (i * m)));
        }

        return answer.toString();
    }
}