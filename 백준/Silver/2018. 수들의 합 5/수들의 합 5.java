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


        solution.solution(num);
    }
}

class Solution {
    public void solution(int k) {

        int lt = 0, sum = 0, answer = 0;

        int[] number = new int[k];

        for(int i = 0; i < k; i++) number[i] = i + 1;

        for(int rt = 0; rt < number.length; rt++){
            sum += number[rt];
            if(sum == k) answer++;
            while(sum >= k){
                sum -= number[lt++];
                if(sum == k) answer++;
            }
        }
        System.out.print(answer);
    }
}