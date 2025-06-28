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
        int target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(arr, target));
    }
}

class Solution {
    public int solution(int[] arr, int target) {

        int left = 0, right = 0, length = arr.length , count = 0, answer = MAX_VALUE;

        for(right = 0; right < length; right++){

            if(arr[right] == 1) count++;

            while(count >= target){

                if(count == target) {
                    answer = Math.min(answer, right - left + 1);
                }

                if(arr[left] == 1){
                    count--;
                }

                left++;

            }
        }

        return answer == MAX_VALUE ? -1 : answer;
    }
}