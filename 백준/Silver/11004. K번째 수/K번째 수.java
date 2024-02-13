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
        int count = Integer.parseInt(st.nextToken());
        int[] num = new int[count];
        int target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        solution.solution(target, num);
    }
}

class Solution {
    public void solution( int target, int[] num) {
        Arrays.sort(num);
        System.out.print(num[target - 1]);
    }
}
