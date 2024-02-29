import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

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
    static final int[] L = {-1, 0};
    static final int[] R = {1, 0};
    static final int[] U = {0, 1};
    static final int[] D = {0, -1};

    public int solution(String dirs) {

        boolean[][][][] visit = new boolean[11][11][11][11];

        Queue<State> queue = new LinkedList<>();

        queue.add(new State(5, 5, 0));
        visit[5][5][5][5] = true;

        int i = 0;

        while(!queue.isEmpty()){
            State state = queue.poll();

            int nx = state.x;
            int ny = state.y;

            if(i == dirs.length()){
                return state.step;
            }

            char c = dirs.charAt(i);

            if(c == 'L'){
                nx += L[0];
                ny += L[1];
            }

            if(c == 'R'){
                nx += R[0];
                ny += R[1];
            }

            if(c == 'U'){
                nx += U[0];
                ny += U[1];
            }

            if(c == 'D'){
                nx += D[0];
                ny += D[1];
            }

            if(nx > 10 || nx < 0 || ny > 10 || ny < 0){
                i++;
                queue.add(new State(state.x, state.y, state.step));
                continue;
            }

             if(!visit[state.y][state.x][ny][nx]){
                visit[state.y][state.x][ny][nx] = true;
                visit[ny][nx][state.y][state.x] = true;
                queue.add(new State(nx, ny, state.step + 1));
            }else{
                queue.add(new State(nx, ny, state.step));
            }
            i++;
        }
        return -1;
    }
}