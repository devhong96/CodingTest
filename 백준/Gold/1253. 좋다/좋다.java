import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int num = parseInt(st.nextToken());
        int[] arr = new int[num];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < arr.length; i++){
            arr[i] = parseInt(st.nextToken());
        }

        System.out.println(solution.solution(arr));
    }
}

class Solution {
    public int solution(int[] arr) {
        int length = arr.length, answer = 0;

        Arrays.sort(arr);

        for (int i = 0; i < length; i++) {
            int target = arr[i], left = 0, right = length - 1;

            while (left < right) {

                if(left == i){
                    left++;
                    continue;
                }

                if(right == i){
                    right--;
                    continue;
                }
                int sum = arr[left] + arr[right];

                if(sum < target){
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
