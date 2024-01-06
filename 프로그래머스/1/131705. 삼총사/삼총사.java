import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        for (int i = 0; i < numbers.length-2; i++) {
            for (int j = i+1; j < numbers.length-1; j++) {
                for (int k = j+1; k <numbers.length ; k++) {
                    if(numbers[i] + numbers[j] + numbers[k] == 0) {
                        answer += 1;
                    }
                }
            }
        }
        return answer;
    }
}