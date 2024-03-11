import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int[] arr = new int[num];
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution.solution(arr, k);
    }
}

class Solution {
    public void solution(int[] arr, int k) {
        int lt = 0, sum = 0, len = 0, answer = MAX_VALUE;

        for(int rt = 0; rt < arr.length; rt++){
            sum += arr[rt];
            len++;
            if(sum >= k) answer = Math.min(answer, len);
            while(sum >= k){
                sum -= arr[lt++];
                len--;
                if(sum >= k) answer = Math.min(answer, len);
            }
        }

        if(answer == MAX_VALUE) answer = 0;
        System.out.print(answer);
    }
}
