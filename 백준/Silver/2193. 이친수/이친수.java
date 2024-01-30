import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        int length = Integer.parseInt(st.nextToken());

        solution.solution(length);
    }
}

class Solution {
    public void solution(int length) {
        
        long[] answer = new long[length + 1];

        answer[0] = 0;
        answer[1] = 1;
        
        for(int i = 2; i <= length; i++){
            answer[i] = answer[i - 2] + answer[i - 1];
        }
        
        System.out.print(answer[length]);
    
    }
}
