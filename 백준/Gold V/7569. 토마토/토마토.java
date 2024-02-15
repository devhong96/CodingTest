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
        int width = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int[][][] box = new int[height][length][width];

        for(int h = 0; h < height; h++){
            for(int l = 0; l < length; l++){
                st = new StringTokenizer(br.readLine());
                for(int w = 0; w < width; w++){
                    box[h][l][w] = Integer.parseInt(st.nextToken());
                }
            }
        }
        System.out.print(solution.solution(box));
    }
}

class Solution {
    private static class State{
        final int x;
        final int y;
        final int z;
        final int step;

        private State(int x, int y, int z, int step){
            this.x = x;
            this.y = y;
            this.z = z;
            this.step = step;
        }
    }
    private static final int[] dx = {0, 0, 1, 0, -1, 0};
    private static final int[] dy = {0, 0, 0, -1, 0, 1};
    private static final int[] dz = {-1, 1, 0, 0, 0, 0};

    private static int answer = 0;
    private static int width, length, height;
    public int solution(int[][][] ground) {
        Queue<State> queue = new LinkedList<>();
        height = ground.length;
        length = ground[0].length;
        width  = ground[0][0].length;

        for(int z = 0; z < ground.length; z++) {
            for (int y = 0; y < ground[z].length; y++) {
                for (int x = 0; x < ground[z][y].length; x++) {
                    if (ground[z][y][x] == 1) {
                        queue.add(new State(x, y, z, 0));
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            State state = queue.poll();
            for(int d = 0; d < 6; d++){
                int nx = state.x + dx[d];
                int ny = state.y + dy[d];
                int nz = state.z + dz[d];

                if(nx < 0 || ny < 0 || nz < 0 ||
                        nx >= width ||
                        ny >= length ||
                        nz >= height) continue;


                if(ground[nz][ny][nx] == 1 || ground[nz][ny][nx] == -1) continue;

                ground[nz][ny][nx] = 1;

                queue.add(new State(nx,ny, nz, state.step + 1));
                answer = state.step + 1;

            }
        }

        for(int z = 0; z < ground.length; z++) {
            for (int y = 0; y < ground[z].length; y++) {
                for (int x = 0; x < ground[z][y].length; x++) {
                    if(ground[z][y][x] == 0) {
                        answer = -1;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}
