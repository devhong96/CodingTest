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

        int[][] arr= new int[count][2];
        for(int i = 0; i < count; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][0] = Integer.parseInt(st.nextToken());
        }
        solution.solution(arr);
    }
}

class Solution {
    public void solution(int[][] arr) {

        Arrays.sort(arr, (s1, s2) -> {
            if(s1[0] == s2[0]){
                return s1[1] - s2[1];
            }else{
                return s1[0] - s2[0];
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (int[] s : arr) {
            sb.append(s[1]).append(" ").append(s[0]).append('\n');
        }
        System.out.println(sb);
    }
}
