import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Solution solution = new Solution();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int total = Integer.parseInt(br.readLine());

        for(int i = 0; i < total; i++){
            int length = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int x0 = Integer.parseInt(st.nextToken());
            int y0 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            sb.append(solution.solution(length, x0, y0, x1, y1)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Solution {
    private static class State{
        public final int x;
        public final int y;
        public final int step;

        private State(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    private static final int[] dx = {2, 2, -1, 1, -2, -2, -1, 1};
    private static final int[] dy = {1, -1, 2, 2, 1, -1, -2, -2};

    public int solution(int length, int x0, int y0, int x1, int y1) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(x0, y0, 0));

        boolean[][] visited = new boolean[length][length];
        visited[y0][x0] = true;

        while(!queue.isEmpty()) {
            State state = queue.poll();

            if(state.x == x1 && state.y == y1) return state.step;

            for (int d = 0; d < 8; d++) {

                int nx = state.x + dx[d];
                int ny = state.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= length || ny >= length) continue;

                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;

                queue.add(new State(nx, ny, state.step + 1));
            }
        }
        return -1;
    }
}
