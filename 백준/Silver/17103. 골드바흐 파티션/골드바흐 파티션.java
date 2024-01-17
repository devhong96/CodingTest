import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int[] arr = new int[a];

        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int j = 2; j < 1000001; j++){
            if(isPrime(j)) set.add(j);
        }
        ArrayList<Integer> primeList = new ArrayList<>(set);
        Collections.sort(primeList);
        for(int num = 0; num < a; num++){
            int answer = 0;
            for(int k = 0; primeList.get(k) < arr[num]; k++){
                if(arr[num] - primeList.get(k) < primeList.get(k)) break;
                if(set.contains(arr[num] - primeList.get(k))) {
                    answer+=1;
                }
            }
            System.out.println(answer);
        }
    }

    static boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
