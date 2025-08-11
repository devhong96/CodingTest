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
        int[][] set = new int[m][3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            set[i][0] = Integer.parseInt(st.nextToken());
            set[i][1] = Integer.parseInt(st.nextToken());
            set[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(n, set));
    }
}

class Solution {
    static int[] unf;

    public static int Find(int num) {
        if(unf[num] == num) return unf[num];
        else return unf[num] = Find(unf[num]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public String solution(int n, int[][] sets) {

        StringBuilder sb = new StringBuilder();

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for (int[] set : sets) {
            if (set[0] == 1) {
                int fa = Find(set[1]);
                int fb = Find(set[2]);
                if (fa != fb) {
                    sb.append("NO").append("\n");
                } else {
                    sb.append("YES").append("\n");
                }
            } else {
                Union(set[1], set[2]);
            }
        }
        return sb.toString();
    }
}
