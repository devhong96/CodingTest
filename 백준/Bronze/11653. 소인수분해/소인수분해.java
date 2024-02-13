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
        for(int i = 2; i * i <= num; i++){
            while(num % i == 0){
                System.out.println(i);
                num /= i;
            }
        }
        if(num != 1) System.out.println(num);
    }
}