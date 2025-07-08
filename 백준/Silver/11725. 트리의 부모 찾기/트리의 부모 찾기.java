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

        int[][] arr = new int[n][2];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(n, arr));

    }
}

class Solution {

    int node;
    boolean[] visited;
    int[] parent;
    List<Integer>[] list;
    public String solution(int n, int[][] arr) {

        node = n;
        list = new ArrayList[node + 1];
        parent = new int[node + 1];
        visited = new boolean[node + 1];

        for (int i = 1; i <= node; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < node - 1; i++) {
            list[arr[i][0]].add(arr[i][1]);
            list[arr[i][1]].add(arr[i][0]);
        }

        return function();
    }

    public String function() {

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= node; i++) {
            queue.offer(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                Integer p = queue.poll();

                for (int next : list[p]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        parent[next] = p;
                        queue.offer(next);
                    }
                }
            }
        }

        for (int i = 2; i <= node; i++) {
            sb.append(parent[i]).append('\n');
        }

        return sb.toString();
    }

}
