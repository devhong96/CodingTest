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
        StringTokenizer st = null;

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < count; j++){
            list.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(solution.solution(list));
    }
}

class Solution {
    public int solution(ArrayList<Integer> list) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (int i : list) {
            pq.offer(i);
        }

        int count = (int)Math.sqrt(list.size());

        for (int i = 0; i < count - 1; i++) {
            pq.poll();
        }

        return pq.poll();
    }
}