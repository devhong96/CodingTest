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
        int num = Integer.parseInt(st.nextToken());

        int[][] arr = new int[num][2];

        for(int y = 0; y < num; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < 2; x++){
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution.solution(arr);
    }
}

class Solution {
    public void solution(int[][] num) {

        Arrays.sort(num, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int end_time = 0;

        for(int i = 0;  i < num.length; i++) {
            if (end_time <= num[i][0]){
                end_time = num[i][1];
                count++;
            }
        }
        System.out.print(count);
    }
}
