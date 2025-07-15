import java.util.*;

class Solution {
    static int target, answer = 0;
    static int[] area;
    public int solution(int n) {
        target = n;
        area = new int[target];
        dfs(0);
        
        return answer;
    }
    
    private void dfs(int depth) {
        if(depth == target){
            answer++;
            return;
        }
        
        for(int i = 0; i < target; i++) {
            area[depth] = i;
            if(isValid(depth)){
                dfs(depth + 1);
            }
        }
    }
    
    private boolean isValid(int depth) {
        
        for(int i = 0; i < depth; i++) {
            if(area[depth] == area[i]) return false;
            if(Math.abs(depth - i) == Math.abs(area[depth] - area[i])) return false;
        }
        
        return true;
    }
}