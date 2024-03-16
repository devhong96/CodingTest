import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num2 = Integer.parseInt(br.readLine());
        int[] arr2 = new int[num2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        solution.solution(arr, arr2);
    }
}

class Solution {
    public void solution(int[] arr, int[] target) {

        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);

        for (int i = 0; i < target.length; i++) {
            sb.append(bottom(arr, target[i]) - top(arr, target[i])).append(' ');
        }
        System.out.print(sb);
    }

    private static int top(int[] arr, int key) {
        int lt = 0;
        int rt = arr.length;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] < key) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }
        return lt;
    }

    private static int bottom(int[] arr, int key) {
        int lt = 0;
        int rt = arr.length;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] <= key) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }
        return lt;
    }
}
