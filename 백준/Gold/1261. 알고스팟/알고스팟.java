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
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[][] maps= new int[height][width];
        for(int y = 0; y < height; y++){
            String str = br.readLine();
            for(int x = 0; x < width; x++) {
                maps[y][x] = str.charAt(x) - '0';
            }
        }
        solution.solution(maps);
    }
}

class Solution {
    static class State implements Comparable<State>{
        public final int x;
        public final int y;
        public final int step;

        public State(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }

        @Override
        public int compareTo(State o) {
            return step - o.step;
        }
    }

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;

    public void solution(int[][] maps) {

        int answer = 10000;
        visited = new boolean[maps.length][maps[0].length];
        PriorityQueue<State> queue = new PriorityQueue<>();

        queue.add(new State(0,0,0));

        while(!queue.isEmpty()){
            State state = queue.poll();

            if(state.x == maps[0].length - 1 && state.y == maps.length - 1)
                System.out.print(state.step);

            for(int d = 0; d < 4; d++){
                int nx = state.x + dx[d];
                int ny = state.y + dy[d];

                if(nx < 0 || nx >= maps[0].length || ny < 0 || ny >= maps.length) continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;
                if(maps[ny][nx] == 1){
                    queue.offer(new State(nx, ny, state.step + 1));
                } else {
                    queue.offer(new State(nx, ny, state.step));
                }
            }
        }
    }
}
