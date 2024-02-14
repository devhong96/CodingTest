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
        int count = Integer.parseInt(st.nextToken());

        for(int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int[][] ground = new int[height][width];
            int area = Integer.parseInt(st.nextToken());

            for(int j = 0; j < area; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ground[y][x] = 1;
            }
            sb.append(solution.solution(ground)).append('\n');
        }
        System.out.print(sb);
    }
}

class Solution {
    private static class State{
        final int x;
        final int y;

        private State(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public int solution(int[][] ground) {
        int count = 0;
        Queue<State> queue = new LinkedList<>();
        for(int y = 0; y < ground.length; y++){
            for(int x = 0; x < ground[y].length; x++){
                if(ground[y][x] == 1){
                    ground[y][x] = 0;
                    count++;
                    queue.add(new State(x, y));
                    while(!queue.isEmpty()){
                        State state = queue.poll();
                        for(int d = 0; d < 4; d++) {
                            int nx = state.x + dx[d];
                            int ny = state.y + dy[d];

                            if(nx < 0 || ny < 0 ||
                                    nx >= ground[0].length || ny >= ground.length) continue;

                            if(ground[ny][nx] == 0) continue;

                            ground[ny][nx] = 0;

                            queue.add(new State(nx, ny));
                        }
                    }
                }
            }
        }
        return count;
    }
}
