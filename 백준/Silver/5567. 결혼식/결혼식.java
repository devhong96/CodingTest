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
    ArrayList<Integer>[] list;
    int node;
    public int solution(int n, int count, int[][] arr) {

        node = n;
        visited = new boolean[node + 1];
        list = new ArrayList[node + 1];

        for (int i = 1; i <= node; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < count; i++) {
            list[arr[i][0]].add(arr[i][1]);
            list[arr[i][1]].add(arr[i][0]);
        }

        return function();
    }

    private int function(){

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int[] dist = new int[node + 1];
        dist[0] = 1;
        int answer = 0;

        while (!queue.isEmpty()) {
            int from = queue.poll();

            for (int next : list[from]) {
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
