import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[][] city = new int[num][num];
        for(int y = 0; y < num; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < num; x++){
                city[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution.solution(city);
    }
}

class Solution {
    static boolean[] visited;
    static int node;
    static int answer = MAX_VALUE;
    static int[][] map;
    public void solution(int[][] city) {
        node = city.length;
        map = city;

        visited = new boolean[node];
        for(int i = 0; i < node; i++){
            visited[i] = true;
            dfs(i, i,0, 1);
        }
        System.out.print(answer);
    }

    public void dfs(int startNode, int nowNode, int sum, int depth) {
        if(depth == node){
            if(map[nowNode][startNode] != 0) {

                sum += map[nowNode][startNode];
                answer = Math.min(answer, sum);
            }
            return;
        }

        for(int i = 0; i < node; i++){
            if(map[nowNode][i] != 0 && !visited[i]) {
                visited[i] = true;
                dfs(startNode, i, sum + map[nowNode][i], depth + 1);
                visited[i] = false;
            }
        }
    }
}