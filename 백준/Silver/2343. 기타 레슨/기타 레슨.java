import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[] lectures = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution.solution(count, lectures));
    }
}

class Solution {
    public int solution(int count, int[] lectures) {

        int min = 0, max = 0, answer = 0;

        for (int lecture : lectures) {
            min = Math.max(lecture, min);
            max += lecture;
        }

        while (min <= max) {
            int mid = (min + max) / 2;

            int sum = 0, num = 1;
            for (int lecture : lectures) {
                if (sum + lecture > mid) {
                    sum = lecture;
                    num++;
                } else {
                    sum += lecture;
                }
            }

            if (num <= count) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }
}