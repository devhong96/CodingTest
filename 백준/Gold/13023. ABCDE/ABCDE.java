import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arrayList;
    static boolean[] visited;
    static boolean checked;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList[node];
        visited = new boolean[node];

        for (int i = 0; i < node; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arrayList[s].add(e);
            arrayList[e].add(s);
        }

        for (int i = 0; i < node; i++) {
            DFS(i, 1);
            if(checked) break;
        }

        int answer = checked ? 1 : 0;
        System.out.println(answer);

    }

    private static void DFS(int now, int depth) {
        if(depth == 5 || checked){
            checked = true;
            return;
        }
        visited[now] = true;
        for(int i : arrayList[now]){
            if(!visited[i])
                DFS(i, depth + 1);
        }
        visited[now] = false;
    }
}