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
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] cable = new int[k];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            cable[i] = Integer.parseInt(st.nextToken());
        }
        solution.solution(n, cable);
    }
}

class Solution {
     public void solution(int n, int[] cable) {

         long max = 0;
         for (int c : cable) if(max < c) max = c;
         max++;

         long min = 0;
         long mid = 0;
         while (min < max) {
             long count = 0;

             mid = (min + max) / 2;

             for (int c : cable) count += (c / mid);

             if(count < n) max = mid;
             else min = mid + 1;
         }
         System.out.println(min - 1);
    }
}
