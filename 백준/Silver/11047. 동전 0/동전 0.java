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
        int sum = Integer.parseInt(st.nextToken());


        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution.solution(sum, arr));
    }
}

class Solution {
    public int solution(int sum, int[] arr) {
        int count = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            while(sum- arr[i] >= 0) {
                sum -= arr[i];
                count++;

            }
        }
        return count;
    }
}
