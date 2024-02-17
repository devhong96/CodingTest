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
        int num = Integer.parseInt(st.nextToken());
        char[][] area = new char[num][num];

        for(int y = 0; y < num; y++){
            String str = br.readLine();
            for(int x = 0; x < num; x++){
                area[y][x] = str.charAt(x);
            }
        }
        solution.solution(area);
    }
}

class Solution {
    static class State{
        public final int x;
        public final int y;

        private State(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};
    private boolean[][] visited;

    public void solution(char[][] area){

        StringBuilder sb = new StringBuilder();
        visited = new boolean[area.length][area[0].length];

        Queue<State> queue = new LinkedList<>();

        int count = 0;
        for(int y = 0; y < area.length; y++){
            for(int x = 0; x < area[0].length; x++){
                if(!visited[y][x]){
                    visited[y][x] = true;
                    queue.add(new State(x, y));
                    while(!queue.isEmpty()){
                        State state = queue.poll();
                        char color = area[state.y][state.x];

                        for(int d = 0; d < 4; d++){
                            int nx = state.x + dx[d];
                            int ny = state.y + dy[d];

                            if(nx < 0 || ny < 0 ||
                                    nx >= area[0].length || ny >= area.length) continue;
                            if(visited[ny][nx]) continue;
                            if(color != area[ny][nx]) continue;

                            visited[ny][nx] = true;
                            queue.add(new State(nx, ny));
                        }
                    }
                    count++;
                }
            }
        }
        sb.append(count).append(' ');

        visited = new boolean[area.length][area[0].length];

        for(int y = 0; y < area.length; y++){
            for(int x = 0; x < area[0].length; x++){
                if(area[y][x] == 'G') area[y][x] = 'R';
            }
        }
        count = 0;
        for(int y = 0; y < area.length; y++){
            for(int x = 0; x < area[0].length; x++){
                if(!visited[y][x]){
                    visited[y][x] = true;
                    queue.add(new State(x, y));
                    while(!queue.isEmpty()){
                        State state = queue.poll();
                        char color = area[state.y][state.x];

                        for(int d = 0; d < 4; d++){
                            int nx = state.x + dx[d];
                            int ny = state.y + dy[d];

                            if(nx < 0 || ny < 0 ||
                                    nx >= area[0].length || ny >= area.length) continue;
                            if(visited[ny][nx]) continue;
                            if(color != area[ny][nx]) continue;

                            visited[ny][nx] = true;
                            queue.add(new State(nx, ny));
                        }
                    }
                    count++;
                }
            }
        }
        sb.append(count);
        System.out.print(sb);
    }
}
