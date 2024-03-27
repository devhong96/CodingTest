import java.util.Arrays;

class Solution {
    static long[] dy = new long[5001];

    public long solution(int k) {

        Arrays.fill(dy, 0);
        return block(k);
    }

    public long block(int num) {
        dy[0] = 1; dy[2] = 3;
        if(dy[num] != 0) return dy[num];
        if(num % 2 == 1) return 0;

        for (int i = 4; i <= num; i += 2) {
            dy[i] = (4 * block(i - 2) - block(i - 4)) % 1000000007;
            if(dy[i] < 0) dy[i] += 1000000007;
        }
        return dy[num];
    }
}