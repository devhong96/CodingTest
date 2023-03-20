import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        A = new int[X][Y];
        visited = new boolean[X][Y];

        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < Y; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        BFS(0, 0);
        System.out.println(A[X - 1][Y - 1]);
    }

    public static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
//            System.out.println("now = " + Arrays.toString(now));
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int x1 = now[0] + dx[k];
//                System.out.print("x = " + x);
                int y1 = now[1] + dy[k];
//                System.out.println(" y = " + y);
                if (x1 >= 0 && y1 >= 0 && x1 < X && y1 < Y) {
                    if (A[x1][y1] != 0 && !visited[x1][y1]) {
                        visited[x1][y1] = true;
                        A[x1][y1] = A[now[0]][now[1]] + 1;
                        queue.add(new int[]{x1, y1});
                    }
                }
            }
        }
    }
}