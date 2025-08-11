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
        int n = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(st.nextToken());
        int[][] set = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            set[i][0] = Integer.parseInt(st.nextToken());
            set[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(n, set));
    }
}

class Solution {
    static int[] unf;

    public static int Find(int num) {if(unf[num] == num) return unf[num];
        else return unf[num] = Find(unf[num]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public int solution(int n, int[][] points) {

        int count = 0;

        unf = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            unf[i] = i;
        }

        for (int[] point : points) {
            count++;
            int fa = Find(point[0]);
            int fb = Find(point[1]);

            if(fa != fb) Union(point[0], point[1]);
            else return count;
        }

        return 0;

    }
}
