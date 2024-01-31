import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] arr = new int[15][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        solution();

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            sb.append(arr[y][x]).append('\n');
        }
        System.out.println(sb);
    }

    public static void solution() {
        for (int i = 0; i < 15; i++) {
            arr[i][1] = 1;
            arr[0][i] = i;
        }

        for (int y = 1; y < 15; y++) {
            for (int x = 1; x < 15; x++) {
                arr[y][x] = arr[y - 1][x] + arr[y][x - 1];
            }
        }
    }
}

