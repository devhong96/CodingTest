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
        int height = Integer.parseInt(st.nextToken());
        int width= Integer.parseInt(st.nextToken());

        int[][] arr = new int[height][width];
        for(int Y = 0; Y < height; Y++){
            st = new StringTokenizer(br.readLine());
            for(int X = 0; X < width; X++) {
                arr[Y][X] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution.solution(arr));
    }
}

class Solution {
    private static class State {
        final int x;
        final int y;
        final int step;

        private State(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

    int[][] originMap;
    int width = 0, height, answer;
    private final int[] dx = {0, 1, 0, -1};
    private final int[] dy = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        originMap = maps;
        width = maps[0].length;
        height = maps.length;

        wall(0);

        return answer;
    }

    private void wall(int depth) {
        if(depth == 3){
            answer = Math.max(answer, count(maps()));
            return;
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                if(originMap[y][x] == 0) {
                    originMap[y][x] = 1;
                    wall(depth + 1);
                    originMap[y][x] = 0;
                }
            }
        }
    }

    private int count(int[][] newMap) {
        int count = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if(newMap[y][x] == 0) count++;
            }
        }

        return count;
    }

    private int[][] maps() {
        int[][] newMap = new int[originMap.length][originMap[0].length];

        for (int i = 0; i < originMap.length; i++) {
            System.arraycopy(originMap[i], 0, newMap[i], 0, originMap[i].length);
        }

        Queue<State> q = new LinkedList<>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if(newMap[y][x] == 2){
                    q.offer(new State(x, y, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            State state = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = state.x + dx[d];
                int ny = state.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= width || ny >= height
                        || newMap[ny][nx] == 2 || newMap[ny][nx] == 1) continue;

                newMap[ny][nx] = 2;

                q.offer(new State(nx, ny, state.step + 1));
            }
        }

        return newMap;
    }
}
