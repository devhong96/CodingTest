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

        int num = Integer.parseInt(st.nextToken());
        int[] number = new int[num];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < num; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        solution.solution(number);
    }
}

class Solution {
     public void solution(int[] number) {
         int length = number.length;
         int[] dy = new int[length];
         int answer = 0;

         for(int i = 0; i < length; i++) {
             dy[i] = 1;
             for (int j = length - 1; j >= 0; j--) {
                 if (number[j] < number[i] && dy[i] < dy[j] + 1){
                     dy[i] = dy[j] + 1;
                 }
             }
         }

         for(int i : dy){
             answer = Math.max(answer, i);
         }
         System.out.println(answer);
    }
}