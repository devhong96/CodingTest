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
        long[] arr = new long[num];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        int num2 = Integer.parseInt(br.readLine());
        long[] arr2 = new long[num2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num2; i++){
            arr2[i] = Long.parseLong(st.nextToken());
        }

        solution.solution(arr, arr2);
    }
}

class Solution {
    public void solution(long[] arr, long[] arr2) {

        int[] answer = new int[arr2.length];
        Arrays.fill(answer, 0);

        Arrays.sort(arr);
        for(int i = 0; i < arr2.length; i++) {
            int lt = 0, rt = arr.length - 1;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                
                if (arr[mid] == arr2[i]) {
                    answer[i] = 1;
                    break;
                }
                if(arr[mid] > arr2[i]) rt = mid - 1;
                else lt = mid + 1;
            }
        }

        for(int i : answer) {
            System.out.println(i);
        }
    }
}
