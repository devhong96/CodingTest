import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        solution.solution(num);
    }
}

class Solution {
    static int target = 0;
    static int count = 0;
    static int[] area;
    public void solution(int num) {
        target = num;
        area = new int[num];
        dfs(0);
        System.out.print(count);
    }

    public void dfs(int depth){
        if(depth == target) {
            count++;
            return;
        }

        for(int i = 0; i < target; i++){
            area[depth] = i;
            if(isTrue(depth)){
                dfs(depth + 1);
            }
        }
    }

    private boolean isTrue(int depth) {
        for (int j = 0; j < depth; j++) {
            if (area[depth] == area[j]) return false;
            if (Math.abs(area[depth] - area[j]) == Math.abs(depth - j)) return false;
        }
        return true;
    }
}
