import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arrayList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList[node + 1];
        visited = new boolean[node + 1];

        st = new StringTokenizer(br.readLine());
        int edge = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= node; i++)
            arrayList[i] = new ArrayList<>();

        for (int i = 0; i < edge; i++) {

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arrayList[s].add(e);
            arrayList[e].add(s);
        }
        BFS(1);
    }

    private static void BFS(int start) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (int i : arrayList[now_node]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    count++;
                }
            }
        }
        System.out.println(count);
    }// BFS 끝
}