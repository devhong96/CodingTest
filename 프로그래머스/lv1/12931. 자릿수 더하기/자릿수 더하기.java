import java.util.*;

public class Solution {
    public int solution(int n) {
        
        int answer=0;
        int num;

        do{
            num=n%10;
            n=n/10;
            answer+=num;
        }while(n>0);
        
        return answer;
    }
}