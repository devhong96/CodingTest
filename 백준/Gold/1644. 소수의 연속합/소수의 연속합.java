import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();

        int k = Integer.parseInt(br.readLine());

        solution.solution(k);
    }
}

class Solution {
    public void solution(int k) {

        ArrayList<Integer> primeList = new ArrayList<>();

        for(int i = 0; i <= k; i++){
            if(isPrime(i)) primeList.add(i);
        }
        int[] arr = new int[primeList.size()];

        for(int i = 0; i < primeList.size(); i++){
            arr[i] = primeList.get(i);
        }

        int sum = 0, answer = 0, lt = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];
            if(sum == k) answer++;
            while(sum >= k){
                sum -= arr[lt++];
                if(sum == k) answer++;
            }
        }
        System.out.print(answer);

    }

    public boolean isPrime(int n) {
        if(n == 0) return false;
        if(n == 1) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
