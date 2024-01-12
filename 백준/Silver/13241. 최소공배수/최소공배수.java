import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long gcd = gcd(a, b);
        long lcm = a * b / gcd;
        
        System.out.print(lcm);
    }
    
    static long gcd(long a, long b){
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        if(max % min == 0) return min;
        return gcd(min, max % min);
    }
}