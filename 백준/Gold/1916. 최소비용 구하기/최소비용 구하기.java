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
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[][] edges = new int[M][3];

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());

        System.out.println(solution.solution(N, m1, m2, edges));
    }
}

class Node implements Comparable<Node> {

    int point;
    int cost;

    public Node(int point, int cost) {
        this.point = point;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node node) {
        return this.cost - node.cost;
    }
}

class Solution {
    public int solution(int node, int m1, int m2, int[][] edges) {

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for(int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[1]).add(new Node(edge[0], edge[2]));
        }

        return function(node, m2, graph)[m1];

    }

    private int[] function(int node, int start, ArrayList<ArrayList<Node>> graph) {
        int[] dist = new int[node + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {

            Node poll = pq.poll();

            int point = poll.point;
            int cost = poll.cost;

            if(cost > dist[point]) continue;

            for (Node nd : graph.get(point)) {
                if(dist[nd.point] > cost + nd.cost) {
                    dist[nd.point] = cost + nd.cost;
                    pq.offer(new Node(nd.point, dist[nd.point]));
                }
            }
        }

        return dist;
    }
}
