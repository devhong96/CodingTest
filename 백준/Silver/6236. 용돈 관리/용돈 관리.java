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

        int count = Integer.parseInt(st.nextToken());
        int[] arr = new int[count];
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution.solution(arr, m));
    }
}

class Solution {
    public int solution(int[] money, int m) {

        int min = 0, max = 0, mid, sum = 0, count, answer = 0;

        for (int i : money) {
            max += i;
            min = Math.max(i, min);
        }

        while(min <= max){
            mid = (min + max) / 2;
            count = 1;
            sum = 0;

            for (int i = 0; i < money.length; i++) {
                sum += money[i];

                if(sum > mid){
                    sum = money[i];
                    count++;
                }
            }

            if(count > m){
                min = mid + 1;
            }
            else {
                answer = mid;
                max = mid - 1;
            }
        }

        return answer;
    }
}
