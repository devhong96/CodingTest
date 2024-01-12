import java.util.*;

class Solution {
    public int answer = 0;
    int count = 0;
    public boolean[] visit;
    public void dfs(int depth, int k, int[][]dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visit[i] && k >= dungeons[i][0]) {
                visit[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visit[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
    public int solution (int k, int[][] dungeons){
        visit = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
}