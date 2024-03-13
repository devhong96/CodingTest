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

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution.solution(arr);
    }
}

class Solution {
    public void solution(int[] arr) {

        int lt = 0, rt = arr.length - 1, min = MAX_VALUE;
        int[] answer = new int[2];

        Arrays.sort(arr);
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (Math.abs(sum) < min) {

                min = Math.abs(sum);
                answer[0] = arr[lt];
                answer[1] = arr[rt];

                if (sum == 0) break;
            }

            if (sum > 0) {
                rt--;
            } else {
                lt++;
            }
        }

        System.out.print(answer[0] + " " + answer[1]);
    }
}