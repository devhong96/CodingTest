import javax.swing.plaf.nimbus.State;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();

        int length = Integer.parseInt(br.readLine());

        int[][] maps = new int[length][length];

        for(int i = 0; i < length; i++){
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

        private State(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};

    public String solution(int[][] maps) {


        StringBuilder answer = new StringBuilder();

        Queue<State> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        int area = 0;
        int home;
        for(int y = 0; y < maps.length; y++) {
            for(int x = 0; x < maps[0].length; x++) {
                if (maps[y][x] == 1) {
                    area++;
                    queue.offer(new State(x, y));
                    home = 0;
                    while (!queue.isEmpty()) {
                        State state = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int nx = state.x + dx[d];
                            int ny = state.y + dy[d];

                            if (nx < 0 || ny < 0 || nx >= maps[0].length || ny >= maps.length) continue;
                            if (maps[ny][nx] == 0) continue;
                            maps[ny][nx] = 0;
                            home++;
                            queue.add(new State(nx, ny));
                        }
                    }
                    list.add(home);
                }
            }
        }
        answer.append(area).append('\n');
        Collections.sort(list);
        for(int i : list){
            if(i == 0){
                answer.append(1).append('\n');
            }else {
                answer.append(i).append('\n');
            }
        }
        return answer.toString();
    }
}
