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
        int target = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution.solution(arr, target);
    }
}

class Solution {
    public void solution(int[] arr, int target) {

        int lt = 0, rt = arr.length - 1, answer = 0;

        Arrays.sort(arr);
        
        while(lt < rt){
            if(arr[lt] + arr[rt] > target){
                rt--;
            }else if(arr[lt] + arr[rt] < target){
                lt++;
            }else{
                answer++;
                lt++;
                rt--;
            }
        }
        System.out.print(answer);
    }
}