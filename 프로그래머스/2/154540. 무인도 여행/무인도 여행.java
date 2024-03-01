import java.util.*;

class Solution {
    static class State{
        public final int x;
        public final int y;
//        public final int sum;

        public State(int x, int y){
            this.x = x;
            this.y = y;
//            this.sum = sum;
        }
    }

    public static final int[] dx = {0, 1, 0, -1};
    public static final int[] dy = {1, 0, -1, 0};

    public static int width;
    public static int length;
    public static boolean[][] visited;
    public List<Integer> solution(String[] maps) {

        width = maps[0].length();
        length = maps.length;
        visited = new boolean[length][width];
        char[][] ground = new char[length][width];

        for(int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {
                ground[y][x] = maps[y].charAt(x);
            }
        }
        System.out.println(Arrays.deepToString(ground));

        Queue<State> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        int area = 0;
        for(int y = 0; y < length; y++) {
            for (int x = 0; x < width; x++) {

                if (!visited[y][x] && ground[y][x] != 'X') {
                    int num = ground[y][x] - '0';
                    area++;
                    queue.add(new State(x, y));
                    visited[y][x] = true;
                    while(!queue.isEmpty()){

                        State state = queue.poll();
                        System.out.println(num);

                        for(int d = 0; d < 4; d++){

                            int ny = state.y + dy[d];
                            int nx = state.x + dx[d];

                            if(nx < 0 || ny < 0 || nx >= width || ny >= length) continue;

                            if(ground[ny][nx] == 'X') continue;
                            if(visited[ny][nx]) continue;

                            visited[ny][nx] = true;
                            num += (ground[ny][nx] - '0');
                            queue.add(new State(nx, ny));
                        }
                    }
                    list.add(num);
                }

            }
        }

        if(list.isEmpty()) list.add(-1);
        Collections.sort(list);
        return list;
    }
}
