import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        int count = Integer.parseInt(br.readLine());
        solution.solution(count);
    }
}

class Solution {

    static int[] dy = new int[1001];

    public static int fibonacci(int n) {

        if(dy[n] != -1) return dy[n];
        if(n == 1 || n == 2) return n;

        return dy[n] = (fibonacci(n - 1) + fibonacci(n - 2)) % 10007;
    }

    public void solution(int count) {
        Arrays.fill(dy, -1);

        System.out.println(fibonacci(count));
    }
}