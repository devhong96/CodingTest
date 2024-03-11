import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        long[] dist = new long[num - 1];
        long[] point = new long[num];


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num - 1; i++){
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num - 1; i++){
            point[i] = Long.parseLong(st.nextToken());
        }

        solution.solution(dist, point);
    }
}

class Solution {
    public void solution(long[] dist, long[] point) {

        long sum = 0;
        long minFuel = point[0];

        for(int i = 0; i < dist.length; i++){
            if(minFuel > point[i]) minFuel = point[i];
            sum += minFuel * dist[i];

        }
        System.out.print(sum);
    }
}
