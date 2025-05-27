import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Solution solution = new Solution();

        int count = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(arr));
    }
}

class Solution {
    public String solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int current = 1;

        for(int num : arr) {

            if(num == current){
                current++;
                while(!stack.isEmpty()){
                    if(stack.peek() == current) {
                        stack.pop();
                        current++;
                    } else {
                        break;
                    }
                }
            } else {
                stack.push(num);
            }
        }

        return stack.isEmpty() ? "Nice" : "Sad";
    }
}