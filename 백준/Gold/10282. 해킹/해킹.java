import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        for (int i = 0; i < count; i++) {

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] edges = new int[d][3];

            for(int j = 0; j < d; j++){
                st = new StringTokenizer(br.readLine());
                edges[j][0] = Integer.parseInt(st.nextToken());
                edges[j][1] = Integer.parseInt(st.nextToken());
                edges[j][2] = Integer.parseInt(st.nextToken());
            }

            sb.append(solution.solution(n, c, edges)).append('\n');
        }

        System.out.println(sb);
    }
}

class Node implements Comparable<Node> {
    public int point;
    public int cost;

    Node(int point, int cost) {
        this.point = point;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node node) {
        return this.cost - node.cost;
    }
}

class Solution {
    public String solution(int n, int c, int[][] edges) {

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        ArrayList<ArrayList<Node>> revGraph = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Node(edge[1], edge[2]));
            revGraph.get(edge[1]).add(new Node(edge[0], edge[2]));
        }

        int[] function = function(n, c, revGraph);
        
        int max = 0, count = 0;
        for (int i = 1; i <= n; i++) {
            if(function[i] != Integer.MAX_VALUE){
                count++;
                max = Math.max(max, function[i]);
            }
        }

        return sb.append(count).append(" ").append(max).toString();
    }

    private int[] function(int n, int start, ArrayList<ArrayList<Node>> graph) {

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();

            int now = tmp.point;
            int cost = tmp.cost;

            if(cost > dist[now]) continue;

            for (Node node : graph.get(now)) {
                if (dist[node.point] > node.cost + cost) {
                    dist[node.point] = node.cost + cost;
                    pq.offer(new Node(node.point, dist[node.point]));
                }
            }
        }

        return dist;
    }
}
