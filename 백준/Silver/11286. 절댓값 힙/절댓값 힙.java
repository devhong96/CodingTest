import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();

        ArrayList<Integer> list = new ArrayList<>();

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(solution.solution(list));
    }
}

class Solution {
    public String solution(ArrayList<Integer> list) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (p1, p2) -> {
                    if(Math.abs(p1) == Math.abs(p2)) return p1 - p2;
                    else return Math.abs(p1) - Math.abs(p2);
                }
        );

        StringBuilder sb = new StringBuilder();

        for (int i : list) {

            if (i != 0) {
                pq.offer(i);
            } else {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()).append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
        }

        return sb.toString();
    }
}