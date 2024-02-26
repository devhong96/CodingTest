import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        char[][] area = new char [Y][X];

        for(int y = 0; y < Y; y++){
            String str = br.readLine();
            for(int x = 0; x < X; x++){
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
        public final int step;

        private State(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public static final int[] dy = {1, 0, -1, 0};
    public static final int[] dx = {0, 1, 0, -1};

    static boolean[][] visited;
    static int width = 0;
    static int length = 0;
    static char[][] ground;
    static int answer = MIN_VALUE;

    public void solution(char[][] area) {
        length = area.length;
        width = area[0].length;
        ground = area;

        for(int y = 0; y < length; y++){
            for(int x = 0; x < width; x++){
                if(area[y][x] == 'L'){
                    answer = Math.max(bfs(x, y), answer);
                }
            }
        }
        System.out.print(answer);
    }

    public int bfs(int x, int y) {

        visited = new boolean[length][width];
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(x, y, 0));
        visited[y][x] = true;

        int count = 0;
        
        while(!queue.isEmpty()){
            State state = queue.poll();

            for(int d = 0; d < 4; d++) {
                int ny = state.y + dy[d];
                int nx = state.x + dx[d];

                if(nx < 0 || ny < 0 || nx >= width || ny >= length) continue;
                if(ground[ny][nx] == 'W') continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;

                queue.add(new State(nx, ny, state.step + 1));
                count = state.step + 1;
            }
        }
        return count;
    }
}