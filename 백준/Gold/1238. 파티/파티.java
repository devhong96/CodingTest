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
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(n, m, x, edges));
    }
}

class Node implements Comparable<Node> {
    public int vex;
    public int cost;

    Node(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node ob) {
        return this.cost - ob.cost;
    }
}

class Solution {

    int[] function(int node, int start, ArrayList<ArrayList<Node>> graph) {

        int[] dis;

        dis = new int[node + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);


        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;

            if(nowCost > dis[now]) continue;

            for (Node ob : graph.get(now)) {
                if (dis[ob.vex] > nowCost + ob.cost) {
                    dis[ob.vex] = nowCost + ob.cost;
                    pq.offer(new Node(ob.vex, nowCost + ob.cost));
                }
            }
        }
        return dis;
    }

    public int solution(int n, int m, int x, int[][] edges) {

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        ArrayList<ArrayList<Node>> revGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            graph.get(edges[i][0]).add(new Node(edges[i][1], edges[i][2]));
            revGraph.get(edges[i][1]).add(new Node(edges[i][0], edges[i][2]));
        }

        int[] to = function(n, x, graph);
        int[] come = function(n, x, revGraph);

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if(to[i] != Integer.MAX_VALUE && come[i] != Integer.MAX_VALUE)
                answer = Math.max(to[i] + come[i], answer);
        }

        return answer;
    }
}
