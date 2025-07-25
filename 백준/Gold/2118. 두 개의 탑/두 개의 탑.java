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
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[k];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            dist[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(dist));
    }
}

class Solution {
    public int solution(int[] dist) {

        int answer = 0, sum = 0, accSum = 0;
        int length = dist.length;

        for(int s : dist) sum += s;

        int left = 0, right = 0;

        while(left < length) {

            //dist[right % length] 추가
            while(right < length * 2 && (accSum + dist[right % length]) * 2 <= sum){
                accSum += dist[right % length];
                right++;
            }

            answer = Math.max(answer, Math.min(sum - accSum, accSum));
            accSum -= dist[left++];
        }

        return answer;
    }
}
