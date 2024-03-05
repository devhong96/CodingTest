import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }
        for (int i : land[land.length - 1]) {
            answer = Math.max(answer, i);
        }
        return answer;
    }
}

//class Solution {
//    static int answer = 0;
//    static boolean[][] visited;
//    int solution(int[][] land) {
//        visited = new boolean[land.length][4];
//
//        for(int i = 0; i < 4; i++){
//            visited[0][i] = true;
//            dfs(land, i, 1, land[0][i]);
//        }
//        return answer;
//    }
//
//    void dfs(int[][] land, int start, int depth, int sum){
//
//        if(depth == land.length){
//            answer = Math.max(sum, answer);
//            return;
//        }
//
//        for(int i = 0; i < 4; i++){
//
//            if (start == i) continue;
//
//            visited[depth][i] = true;
//
//            dfs(land, i, depth + 1, sum + land[depth][i]);
//
//            visited[depth][i] = false;
//        }
//    }
//}