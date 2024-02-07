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

        int[][] arr = new int[height][width];
        for(int Y = 0; Y < height; Y++){
            st = new StringTokenizer(br.readLine());
            for(int X = 0; X < width; X++) {
                arr[Y][X] = Integer.parseInt(st.nextToken());
            }
        }
        solution.solution(arr);
    }
}

class Solution {
    static class State {
         public final int x;
         public final int y;
         public final int step;

        public State(int x, int y, int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public void solution(int[][] maps) {

        int answer = 0;
        Queue<State> queue = new LinkedList<>();

        for(int y = 0; y < maps.length; y++){
            for(int x = 0; x < maps[y].length; x++){
                if(maps[y][x] == 1){
                    queue.offer(new State(x, y, 0));
                }
            }
        }

        while(!queue.isEmpty()){
            State state = queue.poll();
            for(int d = 0; d < 4; d++) {
                int ny = state.y + dy[d];
                int nx = state.x + dx[d];

                if(nx < 0 || nx>= maps[0].length || ny < 0 || ny >= maps.length ||
                    maps[ny][nx] == 1 || maps[ny][nx] == -1) continue;

                maps[ny][nx] = 1;
                queue.offer(new State(nx, ny, state.step + 1));
            }

            if(queue.isEmpty()){
                for(int y = 0; y < maps.length; y++){
                    for(int x = 0; x < maps[y].length; x++){
                        answer = Math.max(answer , state.step);
                    }
                }
            }
        }
        for(int y = 0; y < maps.length; y++){
            for(int x = 0; x < maps[y].length; x++){
                if (maps[y][x] == 0) {
                    answer = -1;
                    break;
                }
            }
        }
        System.out.print(answer);
    }
}
