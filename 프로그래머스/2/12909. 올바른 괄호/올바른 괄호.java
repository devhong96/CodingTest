import java.util.*;

class Solution {
    public boolean solution(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                stack.pop();

            }
        }
        return stack.isEmpty();

    }
}

