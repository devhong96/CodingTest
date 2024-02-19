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
        int[][] area = new int[num][num];

        for(int y = 0; y < num; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < num; x++){
                area[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution.solution(area);
    }
}

class Solution {
    static class State{
        public final int x;
        public final int y;

        public State(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};

    private static boolean[][] visited;

    public void solution(int[][] ground) {
        int W = ground[0].length;
        int H = ground.length;

        int max = 0;
        for(int y = 0; y < H; y++){
            for(int x = 0; x < W; x++){
                max = Math.max(max, ground[y][x]);
            }
        }

        int answer = 0;
        Queue<State> queue = new LinkedList<>();

        for(int h = 0; h < max; h++) {
            int area = 0;
            visited = new boolean[H][W];

            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    if (!visited[y][x] && ground[y][x] > h) {
                        queue.add(new State(x, y));
                        area++;

                        while (!queue.isEmpty()) {
                            State state = queue.poll();
                            for (int d = 0; d < 4; d++) {
                                int ny = state.y + dy[d];
                                int nx = state.x + dx[d];

                                if (nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
                                if (visited[ny][nx]) continue;
                                if (ground[ny][nx] <= h) continue;

                                visited[ny][nx] = true;
                                queue.add(new State(nx, ny));
                            }
                        }
                    }
                    answer = Math.max(area, answer);
                }
            }
        }
        System.out.print(answer);
    }
}
