class Solution {
    public int solution(int x, int y, int n) {
        int[] dy = new int[y + 1];

        for (int i = 0; i <= y; i++) {
            dy[i] = Integer.MAX_VALUE;
        }

        dy[x] = 0;

        for (int i = x; i <= y; i++) {
            if(dy[i]==Integer.MAX_VALUE) continue;
            
            if (i + n <= y) {
                dy[i + n] = Math.min(dy[i + n], dy[i] + 1);
            }
            if (i * 2 <= y) {
                dy[i * 2] = Math.min(dy[i * 2], dy[i] + 1);
            }
            if (i * 3 <= y) {
                dy[i * 3] = Math.min(dy[i * 3], dy[i] + 1);
            }
        }

        if (dy[y] == Integer.MAX_VALUE) {
            return -1;
        }
        return dy[y];
    }
}