import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        for(char x : s.toCharArray()){
            if(x=='(') stack.push(x);
            else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;
        return answer;
    }
}