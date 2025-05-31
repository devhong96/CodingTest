import java.util.*;

class Solution {
    public long solution(long w, long h) {
        
        long answer = 0;

        for(int x = 0; x < w; x++) {
            answer += h * x / w;
        }
        
        return answer * 2;
    }
}