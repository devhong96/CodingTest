import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        
        int gcd = gcd(num1, num2);
        
        System.out.println(gcd);
        System.out.println(num1 * num2 / gcd);
    }
    
    public static int gcd(int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if(max % min == 0) return min;
        return gcd(min, max % min);
    }
}