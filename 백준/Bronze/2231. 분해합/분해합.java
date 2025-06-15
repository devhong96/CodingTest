import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Solution solution = new Solution();

        int num = Integer.parseInt(br.readLine());
        System.out.println(solution.solution(num));
    }
}


class Solution {
    public int solution(int num) {

        for(int i = 0; i < num; i++){

            int sum = i;
            int n = i;
            while(n != 0) {
                sum += n % 10;
                n/=10;
            }

            if(num == sum){
                return i;
            }
        }
        
        return 0;
    }
}