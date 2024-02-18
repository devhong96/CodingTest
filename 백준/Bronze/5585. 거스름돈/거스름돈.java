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
    public void solution(int num) {
        int count = 0;
        int charge = 1000 - num;

        if(charge / 500 >= 0){
            count += (charge / 500);
            charge %= 500;
        }

        if(charge / 100 >= 0){
            count += (charge / 100);
            charge %= 100;
        }

        if(charge / 50 >= 0){
            count += (charge / 50);
            charge %= 50;
        }

        if(charge / 10 >= 0){
            count += (charge / 10);
            charge %= 10;
        }

        if(charge / 5 >= 0){
            count += (charge / 5);
            charge %= 5;
        }

        if(charge >= 1){
            count += charge;
        }
        
        System.out.print(count);
    }
}
