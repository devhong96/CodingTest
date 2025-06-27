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
        int[] arr = new int[num];
        int target = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(arr, target));
    }
}

class Solution {
    public int solution(int[] arr, int target) {

        int lt = 0, rt = arr.length - 1, answer = 0;

        Arrays.sort(arr);

        while(lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (sum == target) {
                answer++;
                lt++;
                rt--;
            } else if (sum < target) {
                lt++;
            } else {
                rt--;
            }
        }

        return answer;
    }
}