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

        int[] tree = new int[k];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }
        solution.solution(n, tree);
    }
}

class Solution {
     public void solution(int n, int[] tree) {
         long max = 0;
         for(int t : tree) if(max < t) max = t;

         long mid = 0;
         long min = 0;

         while(min < max) {
             long sum = 0;

             mid = (min + max) / 2;

             for (int t : tree) {
                 if(t > mid) {
                     sum += (t - mid);
                 }
             }

             if(sum >= n) min = mid + 1;
             else max = mid;
         }
         System.out.println(min - 1);
    }
}