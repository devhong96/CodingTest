import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] sign = new int[4];

        for(int j = 0; j < 4; j++){
            sign[j] = Integer.parseInt(st.nextToken());
        }

        solution.solution(num, sign);
    }
}

class Solution {
    static int[] number;
    static int[] operation;
    static int max = MIN_VALUE;
    static int min = MAX_VALUE;
    public void solution(int[] num, int[] sign) {

        number = num;
        operation = sign;

        dfs(1, num[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public void dfs(int depth, int value) {
        if(depth == number.length){
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(operation[i] > 0) {
                operation[i]--;
                switch (i) {
                    case 0 : dfs(depth + 1, value + number[depth]); break;
                    case 1 : dfs(depth + 1, value - number[depth]); break;
                    case 2 : dfs(depth + 1, value * number[depth]); break;
                    case 3 : dfs(depth + 1, value / number[depth]); break;
                }
                operation[i]++;
            }
        }
    }
}
