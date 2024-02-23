import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        String[] arr = new String[num];
        for(int i = 0; i < num; i++){
            arr[i] = br.readLine();
        }
        solution.solution(arr);
    }
}

class Solution {
    static int[] arr = new int[26];
    public void solution(String[] str) {

        for (String s : str) {
            for (int j = 0; j < s.length(); j++) {
                int l = s.length() - j - 1;
                arr[s.charAt(j) - 'A'] += (int) Math.pow(10, l);
            }
        }

        Arrays.sort(arr);
        int answer = 0;
        int num = 9;

        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == 0) continue;
            answer += (arr[i] * num);
            num--;
        }

        System.out.print(answer);
    }
}
