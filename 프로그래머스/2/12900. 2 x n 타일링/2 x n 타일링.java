import java.util.*;

class Solution {
    static long[] dy = new long[60001];

    public long solution(int num) {
        Arrays.fill(dy, -1);
        return tile(num);
    }

    public static long tile(int num) {
        dy[1] = 1;
        dy[2] = 2;

        if(dy[num] != -1) return dy[num];
        if(num == 1 || num == 2) return num;

        return dy[num] = (tile(num - 1)+ tile(num - 2)) % 1000000007;
    }
}