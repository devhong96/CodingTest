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
        int[] arr = new int[num];
        int range = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(arr, range));
    }
}

class Solution {
    public int solution(int[] arr, int range) {

        int answer = 0, sum = 0;

        for (int i = 0; i < range; i++) {
            sum += arr[i];
        }
        
        answer = sum;

        for (int i = range; i < arr.length; i++) {
            sum += (arr[i] - arr[i - range]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}