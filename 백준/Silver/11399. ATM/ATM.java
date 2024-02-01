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

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution.solution(arr));
    }
}

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i; j++){
                sum += arr[j];
            }
        }
        return sum;
    }
}
