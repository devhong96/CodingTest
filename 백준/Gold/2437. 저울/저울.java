import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();

        int count = Integer.parseInt(br.readLine());
        int[] num = new int[count];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(num));
    }
}

class Solution {
    public int solution(int[] weights) {

        Arrays.sort(weights);

        int answer = 1;

        for (int w : weights) {
            if (w > answer) {
                break;
            }
            answer += w;
        }

        return answer;
    }
}