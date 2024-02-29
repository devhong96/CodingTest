import java.util.*;

class Solution {
    static class State{
        public final int x;
        public final int y;
        public final int step;

        public State(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    public static final int[] dx = {1, 0, -1, 0};
    public static final int[] dy = {0, 1, 0, -1};

    static int width;
    static int length;
    public int solution(String[] maps) {

        width = maps[0].length();
        length = maps.length;

        int case1 = bfs(maps, 'S', 'L');
        int case2 = bfs(maps, 'L', 'E');

        if(case1 == -1 || case2 == -1) return -1;
        return case1 + case2;
    }

    public int bfs(String[] maps, char start, char target){

        Queue<State> queue = new LinkedList<>();
        boolean[][] visit = new boolean[length][width];

        int end_X = 0;
        int end_Y = 0;

        for(int y = 0; y < length; y++){
            for(int x = 0; x < width; x++){

                if(maps[y].charAt(x) == start){
                    queue.add(new State(x, y, 0));
                    visit[y][x] = true;
                }

                if(maps[y].charAt(x) == target){
                    end_X = x;
                    end_Y = y;
                }
            }
        }

        while(!queue.isEmpty()){

            State state = queue.poll();

            if(state.x == end_X && state.y == end_Y) return state.step;

            for(int d = 0; d < 4; d++){

                int nx = state.x + dx[d];
                int ny = state.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= width || ny >= length) continue;

                if(maps[ny].charAt(nx) == 'X') continue;

                if(visit[ny][nx]) continue;

                visit[ny][nx] = true;
                queue.add(new State(nx, ny, state.step + 1));
            }
        }
        return -1;
    }
}