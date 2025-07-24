import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken());
        int E = parseInt(st.nextToken());

        int[][] edges = new int[E][3];

        for (int i = 0; i < E; i++) {

            st = new StringTokenizer(br.readLine());

            edges[i][0] = parseInt(st.nextToken());
            edges[i][1] = parseInt(st.nextToken());
            edges[i][2] = parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int m1 = parseInt(st.nextToken());
        int m2 = parseInt(st.nextToken());

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

    int[] function(int node, int start, ArrayList<ArrayList<Node>> graph) {
        int[] dist = new int[node + 1];

        Arrays.fill(dist, MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();

            int point = tmp.point;
            int cost = tmp.cost;

            if(cost > dist[point]) continue;

            for (Node nd : graph.get(point)) {
                if (dist[nd.point] > cost + nd.cost) {
                    dist[nd.point] = cost + nd.cost;
                    pq.offer(new Node(nd.point, dist[nd.point]));
                }
            }
        }

        return dist;
    }

    public int solution(int node, int m1, int m2, int[][] edges) {

        ArrayList<ArrayList<Node>> revGraph = new ArrayList<>();

        for (int i = 0; i <= node; i++) {
            revGraph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            revGraph.get(edge[1]).add(new Node(edge[0], edge[2]));
            revGraph.get(edge[0]).add(new Node(edge[1], edge[2]));
        }

        int answer = -1;

        int[] d1 = function(node, 1, revGraph);
        int[] d2 = function(node, m1, revGraph);
        int[] d3 = function(node, m2, revGraph);
        int[] dn = function(node, node, revGraph);

        long path1Cost = (long)d1[m1] + d2[m2] + d3[node];

        long path2Cost = (long)d1[m2] + d3[m1] + d2[node];

        for (int i = 0; i <= node; i++) {
            if (d1[i] != MAX_VALUE && d2[i] != MAX_VALUE &&
                    d3[i] != MAX_VALUE && dn[i] != MAX_VALUE)
            {
                answer = (int)Math.min(path1Cost, path2Cost);
            }
        }

        return answer;
    }
}
