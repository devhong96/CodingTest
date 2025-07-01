import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution.solution(num, arr));
    }
}

class Solution {
    public int solution(int num, int[] arr) {

        int left = 1, right = 0, mid = 0, sum, length = arr.length;

        int answer = 0;

        for (int i : arr) {
            right = Math.max(right, i);
        }

        while(left <= right){
            mid = (left + right) / 2;
            sum = 0;

            for (int i = 0; i < length; i++) {
                if(arr[i] % mid == 0){
                    sum += arr[i] / mid;
                } else {
                    sum += arr[i] / mid + 1;
                }
            }


            if(sum > num) left = mid + 1;
            else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}
