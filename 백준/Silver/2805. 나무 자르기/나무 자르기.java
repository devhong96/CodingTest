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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(M, trees));
    }
}

class Solution {
    public int solution(int M, int[] trees) {

        int answer = 0;
        int min = 0, max = 0;
        for(int tree : trees){
            max = Math.max(tree, max);
        }

        while (min <= max) {
            long sum = 0;
            int mid = (min + max) / 2;

            for (int tree : trees) {
                if(tree - mid > 0){
                    sum += tree - mid;
                }
            }

            if(sum >= M){
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }

        return answer;
    }
}