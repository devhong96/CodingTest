import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Solution solution = new Solution();

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(solution.solution(n, k));
    }
}

class Solution {
    public String solution(int n, int k) {

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        sb.append("<");
        while(!deque.isEmpty()){
            for (int i = 0; i < k - 1; i++) {
                deque.addLast(deque.poll());
            }
            sb.append(deque.poll());
            if(!deque.isEmpty()) sb.append(", ");
        }

        sb.append(">");
        return sb.toString();
    }
}