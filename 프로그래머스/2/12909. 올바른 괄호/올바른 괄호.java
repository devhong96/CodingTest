import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(c);
            if(c == ')'){
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) answer = false;
        return answer;
    }
}