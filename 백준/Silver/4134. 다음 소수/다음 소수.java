import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        long num = Long.parseLong(st.nextToken());

        for(long i = 0; i < num; i++){
            long a = Long.parseLong(br.readLine());

            for(long k = a; ;k++){
                if(k == 0 || k == 1) {
                    System.out.println(2);
                    break;
                }
                if(isPrime(k)){
                    System.out.println(k);
                    break;
                }
            }
        }
    }

    static boolean isPrime(long n){
        if(n == 0 || n == 1) return false;
        for(long j = 2; j * j <= n; j++){
            if(n % j == 0)return false;
        }
        return true;
    }
}