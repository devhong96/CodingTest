import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());

        int count = 0;
        for(int i=1; i<=num; i++){
            int n = i;
            while(n%5==0){
                count++;
                n/=5;
            }
        }
        System.out.println(count);
    }
}