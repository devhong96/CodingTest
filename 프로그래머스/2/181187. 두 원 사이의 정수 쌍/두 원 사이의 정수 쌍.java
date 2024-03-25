class Solution {
    public long solution(int k, int d) {

        long answer = 0;
        for (int r = 1; r <= d; r++) {
            long minH = (long) Math.ceil(Math.sqrt(1.0 * k * k - 1.0 * r * r));
            long maxH = (long) Math.floor(Math.sqrt(1.0 * d * d - 1.0 * r * r));
            answer += (maxH - minH + 1);
        }
        return answer * 4;
    }
}