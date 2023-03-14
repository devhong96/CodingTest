import java.util.*;

class Solution{
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        
        for(int i = 1; i < s.length(); i++){
            int x = s.lastIndexOf(s.charAt(i), i-1);
            System.out.println(s.charAt(i)+ " i = " + i + " x = " + x);
                
            if(x != -1){
                answer[i] = i-x;
            }else{
                answer[i] = x;                }
        }
        return answer;
    }
}

