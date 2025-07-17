import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(n, p1, p2, arr));

    }
}

class Solution {

    ArrayList<ArrayList<Integer>> graph;
    boolean[] visited;
    int node;
    public int solution(int n, int p1, int p2, int[][] arr) {

        graph = new ArrayList<>();
        node = n;
        visited = new boolean[node + 1];

        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] ar : arr) {
            graph.get(ar[1]).add(ar[0]);
            graph.get(ar[0]).add(ar[1]);
        }

        return function(p1, p2);
    }

    private int function(Integer start, Integer end) {

        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer from = queue.poll();
                if (from == end) return answer;

                for (int next : graph.get(from)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            answer++;

        }
        return -1;
    }
}
