import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int gcd = GCD(answer, arr[i]);
            answer = answer * arr[i] / gcd;
        }
        return answer;
    }

    private int GCD(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if(max % min == 0){
            return min;
        }
        return GCD(min, max % min);
    }
}