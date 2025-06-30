import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(solution.solution(a, b));
    }
}

class Solution {
    public long solution(long x, long y) {

        if(x == y || 99 <= (y * 100) / x) {
            return -1;
        }

        long z = (y * 100) / x;
        long l = 0, r = 1000000000, m = -1;

        while(l <= r) {
            m  = (l + r) / 2;
            long i = (y + m) * 100 / (x + m);
            if(i <= z){
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }
}
