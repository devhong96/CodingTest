import java.util.*;

class Solution {
    public int solution(int n, int digit) {

        int answer = 0;
        String str = Integer.toString(n, digit);

        String[] split = str.split("0");
        for (String s : split) {
            if(s.isEmpty()) continue;
            long num = Long.parseLong(s);
            if (isPrime(num)) answer++;
        }
        return answer;
    }

    public boolean isPrime(long num) {
        if(num == 0 || num == 1) return false;
        for (int i = 2; i<= Math.sqrt(num); i++)
            if(num % i == 0) return false;  
        return true;
    }
}