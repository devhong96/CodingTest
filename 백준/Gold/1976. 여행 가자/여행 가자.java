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
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[][] cities = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                cities[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[] target = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(cities, target));
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

    public String solution(int[][] cities, int[] targets) {

        unf = new int[cities.length + 1];
        for (int i = 1; i <= cities.length; i++) {
            unf[i] = i;
        }

        int index = 0;
        for (int[] city : cities) {
            // 몇 번째 줄 == 몇 번째 도시
            index++;
            int count = 0;
            for (int c : city) {
                count++;
                if(c == 1) {
                    Union(index, count);
                }
            }
        }
        
        int root = Find(targets[0]);
        for(int target : targets){
            if(root != Find(target)) return "NO";
        }

        return "YES";
    }
}
