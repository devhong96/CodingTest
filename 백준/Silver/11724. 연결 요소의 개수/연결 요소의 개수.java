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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken()) - 1;
            arr[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        System.out.println(solution.solution(N, arr));

    }
}

class Solution {

    int[][] graph;
    boolean[] visited;
    int node;
    public int solution(int N, int[][] arr) {

        int count = 0;

        graph = new int[N][N];
        visited = new boolean[N];
        node = N;

        for (int[] ar : arr) {
            graph[ar[0]][ar[1]] = 1;
            graph[ar[1]][ar[0]] = 1;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                count++;
                bfs(i);
            }
        }

        return count;
    }

    private void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int n = 0; n < node; n++) {
                if(graph[poll][n] == 1 && !visited[n]){
                    queue.offer(n);
                    visited[n] = true;
                }
            }
        }
    }
}
