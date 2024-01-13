import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = a; i <= b; i++) {
            if(isPrime(i)) System.out.println(i);
        }
    }
    static boolean isPrime(int n){
        if(n == 1 || n == 0) return false;
        for (int i = 2; i*i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}