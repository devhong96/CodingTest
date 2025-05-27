import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();

        int num = Integer.parseInt(br.readLine());


        System.out.println(solution.solution(num));
    }
}

class Solution {
    public int solution(int num) {

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 1; i <= num; i++) {
            dq.offer(i);
        }

        while (dq.size() > 1) {
            dq.pop();
            
            Integer pop = dq.pop();
            dq.addLast(pop);
        }

        return dq.pop();
    }
}