import java.util.*;

class Solution {
    public long solution(long n) {
        
       String answer = "";

        String[] str = Long.toString(n).split("");
        Arrays.sort(str, Comparator.reverseOrder());

        for (String s : str) answer+=s;


        return Long.parseLong(answer);
    }
}