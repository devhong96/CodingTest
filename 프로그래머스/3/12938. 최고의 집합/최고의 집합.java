import java.util.*;

class Solution {
    public int[] solution(int n, int s) {

        if(n > s) return new int[]{ -1 };
        int[] answer = new int[n];

        Arrays.fill(answer, s / n);

        int remain = s % n;
        for (int i = n - 1; i >= n - remain; i--) {
            answer[i] += 1;
        }

        return answer;
    }
}