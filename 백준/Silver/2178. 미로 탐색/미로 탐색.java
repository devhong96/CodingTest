import javax.swing.plaf.nimbus.State;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int line = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        int[][] maps = new int[line][length];

        for(int i = 0; i < line; i++){
            String s = br.readLine();
            for(int j = 0; j < length; j++){
                maps[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.print(solution.solution(maps));
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

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()){
            State state = queue.poll();

            if(state.y == maps.length - 1 && state.x == maps[state.y].length - 1){
                return state.step;
            }

            for(int d = 0; d < 4; d++){
                int nx = state.x + dx[d];
                int ny = state.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= maps[0].length || ny >= maps.length) continue;

                if(maps[ny][nx] != 1) continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;
                queue.add(new State(nx, ny, state.step + 1));
            }
        }
        return -1;
    }
}
