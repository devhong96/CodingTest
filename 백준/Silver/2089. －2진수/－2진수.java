import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();

        int num = Integer.parseInt(br.readLine());
        solution.solution(num);
    }
}

class Solution {
    public void solution(int num) {
        StringBuilder sb = new StringBuilder();
        while(num != 1){
            sb.append(Math.abs(num % (-2)));
            num = (int)Math.ceil((double)num / (-2));
            if(num == 0) break;
        }
        if(num == 1) sb.append(1);
        System.out.println(sb.reverse());
    }
}
