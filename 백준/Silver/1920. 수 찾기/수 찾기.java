import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        int num2 = Integer.parseInt(br.readLine());
        long[] arr2 = new long[num2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num2; i++){
            arr2[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(solution.solution(arr, arr2));
    }
}

class Solution {
    public String solution(long[] original, long[] target) {

        StringBuilder sb = new StringBuilder();

        Arrays.sort(original);

        for (int i = 0; i < target.length; i++) {
            int lt = 0, rt = original.length - 1;
            int result = 0;

            while (lt <= rt) {
                int mid = (lt + rt) / 2;

                if (original[mid] == target[i]) {
                    result = 1;
                    break;
                }

                if (original[mid] < target[i]) lt = mid + 1;
                else rt = mid - 1;
            }

            sb.append(result).append('\n');
        }

        return sb.toString();
    }
}
