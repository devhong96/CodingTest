import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int size = numbers.length;
        int[] answer = new int[size];
        Arrays.fill(answer, -1);
        
        int index = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }
}