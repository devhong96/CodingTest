import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [][] jewel = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> back = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            back.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution.solution(jewel, back));
    }
}

class Solution {
    static class Jewel {
        final int m;
        final int v;

        Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
    public long solution(int[][] jewels, ArrayList<Integer> backList) {

        ArrayList<Jewel> jewelList = new ArrayList<>();

        for (int[] jewel : jewels) {
            int m = jewel[0];
            int v = jewel[1];

            jewelList.add(new Jewel(m, v));
        }

        jewelList.sort(Comparator.comparingInt(p -> p.m));

        Collections.sort(backList);
        PriorityQueue<Jewel> pq = new PriorityQueue<>((p1, p2) -> p2.v - p1.v);

        long answer = 0;
        int index = 0;

        for (Integer back : backList) {
            while (index < jewelList.size()
                    && jewelList.get(index).m <= back) {
                Jewel jewel = jewelList.get(index++);
                pq.offer(jewel);
            }

           if(!pq.isEmpty()) answer += pq.poll().v;

        }

        return answer;
    }
}