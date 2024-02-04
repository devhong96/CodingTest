import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if(X == 0 && Y == 0) break;

            int[][] maps = new int[Y][X];

            for (int i = 0; i < Y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < X; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(solution.solution(maps));
        }
    }
}

class Solution {
    private static class State{
        public final int x;
        public final int y;

        private State(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    private static final int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public int solution(int[][] maps) {

        Queue<State> queue = new LinkedList<>();

        int count = 0;
        for(int y = 0; y < maps.length; y++){
            for(int x = 0; x < maps[0].length; x++){
                if(maps[y][x] == 1) {
                    count++;
                    queue.add(new State(x, y));
                    maps[y][x] = 0;
                    while (!queue.isEmpty()) {
                        State state = queue.poll();
                        for(int d = 0; d < 8; d++){
                            int ny = state.y + dy[d];
                            int nx = state.x + dx[d];
                            if(nx < 0 || nx >= maps[0].length || ny < 0 || ny >= maps.length
                                || maps[ny][nx] == 0) continue;
                            maps[ny][nx] = 0;
                            queue.add(new State(nx, ny));
                        }
                    }
                }
            }
        }
        return count;
    }
}
