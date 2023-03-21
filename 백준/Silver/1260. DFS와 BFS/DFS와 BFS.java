import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arrayList;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList[node + 1];
        sb = new StringBuilder();

        for (int i = 1; i <= node; i++)
            arrayList[i] = new ArrayList<>();

        for (int i = 0; i < edge; i++) {

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arrayList[s].add(e);
            arrayList[e].add(s);
        }

        for (int i = 1; i <= node; i++)
            Collections.sort(arrayList[i]);


        visited = new boolean[node + 1];
        DFS(start);
        sb.append("\n");
        visited = new boolean[node + 1];
        BFS(start);
        System.out.println(sb);
    }


    private static void DFS(int start) {

        sb.append(start).append(" ");
        visited[start] = true;

        for(int i : arrayList[start])
            if(!visited[i]) DFS(i);
    }// DFS 끝

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now_node = queue.poll();
            sb.append(now_node).append(" ");

            for (int i : arrayList[now_node]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }// while 끝
    }// BFS 끝
}