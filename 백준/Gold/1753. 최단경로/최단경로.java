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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        int[][] edge = new int[E][3];

        for (int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            edge[i][0] = Integer.parseInt(st.nextToken());
            edge[i][1] = Integer.parseInt(st.nextToken());
            edge[i][2] = Integer.parseInt(st.nextToken());

        }

        System.out.println(solution.solution(V, K, edge));
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
    public String solution(int V, int K, int[][] edges) {

        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(new Node(edge[1], edge[2]));
        }

        int[] function = function(V, K, graph);
        
        for (int i = 1; i <= V; i++) {
            int answer = function[i];
            if (i == K) {
                sb.append(0).append('\n');
            } else if (answer != Integer.MAX_VALUE) {
                sb.append(answer).append('\n');
            } else {
                sb.append("INF").append('\n');
            }
        }

        return sb.toString();
    }

    int[] function(int n, int start, ArrayList<ArrayList<Node>> graph) {

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();

            int point = tmp.point;
            int cost = tmp.cost;

            if(cost > dist[point]) continue;

            for (Node node : graph.get(point)) {
                if (dist[node.point] > node.cost + cost) {
                    dist[node.point] = node.cost + cost;
                    pq.offer(new Node(node.point, dist[node.point]));
                }
            }
        }
        
        return dist;
    }
}
