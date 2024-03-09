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
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());
        solution.solution(arr, k);
    }
}

class Solution {

    public void solution(int[] arr, int k) {

        Arrays.sort(arr);

        int lt = 0, rt = arr.length -1, answer = 0;

        while(lt < rt){
            int sum = arr[lt] + arr[rt];
            if(sum == k){
                answer++;
                lt++;
                rt--;
            }else if(sum > k){
                rt--;
            }else{
                lt++;
            }
        }
        System.out.print(answer);
    }
}
