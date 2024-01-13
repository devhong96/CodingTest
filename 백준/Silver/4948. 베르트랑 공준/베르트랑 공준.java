import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break;
            int answer = 0;
            for(int i = num + 1; i <= 2 * num; i++){
                if(isPrime(i)) answer++;
            }
            System.out.println(answer);
        }
    }

    static boolean isPrime(int n){
        if(n == 1 || n == 0) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}
