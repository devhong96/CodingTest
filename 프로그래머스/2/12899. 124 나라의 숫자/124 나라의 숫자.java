import java.util.*;

class Solution {
    public String solution(int n) {

        int[] digit = {4, 1, 2};
        StringBuilder answer = new StringBuilder();

        while(n > 0){
            int reaminer = n % 3;
            answer.insert(0, digit[reaminer]);
            if(reaminer == 0) {
                n = (n / 3) - 1;
            } else {
                n /= 3;
            }
        }

    
        return answer.toString();
    }
}