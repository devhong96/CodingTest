import javax.swing.*;
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
        int count = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());

        int[] arr = new int[count];
        for(int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution.solution(arr);
    }
}

class Solution {
    public void solution(int[] arr) {

        Arrays.sort(arr);

        int max = arr[arr.length - 1];
        double sum = 0;

        for(double num : arr) {
            sum += (num / max * 100);
        }

        System.out.println(sum / arr.length);
    }
}
