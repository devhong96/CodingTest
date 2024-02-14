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
        int count = Integer.parseInt(st.nextToken());
        int[][] point = new int[count][2];

        for(int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());

        }
        solution.solution(point);
    }
}

class Solution {
    public void solution(int[][] point) {
        Arrays.sort(point, (p1, p2) ->{
            if(p1[0] == p2[0]){
                return p1[1] - p2[1];
            } else {
                return p1[0] - p2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int[] p : point) {
            sb.append(p[0]).append(" ").append(p[1]).append('\n');
        }
        System.out.println(sb);
    }
}
