import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        int[][] arr = new int[count][2];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(n, count, arr));

    }
}

class Solution {

    boolean[] visited;
    ArrayList<ArrayList<Integer>> graph;
    int node;
    public int solution(int n, int count, int[][] arr) {

        node = n;
        visited = new boolean[node + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < count; i++) {
            graph.get(arr[i][0]).add(arr[i][1]);
            graph.get(arr[i][1]).add(arr[i][0]);
        }

        return function();
    }

    private int function(){

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;
        int[] dist = new int[node + 1];
        dist[0] = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            int from = queue.poll();

            for (int next : graph.get(from)) {
                if (!visited[next]) {
                    dist[next] = dist[from] + 1;
                    visited[next] = true;
                    queue.offer(next);

                    if(dist[next] <= 2) answer++;
                }
            }
        }


        return answer;
    }
}
