import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++){
            
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            int gcd = gcd(A, B);
            
            sb.append(A * B / gcd).append('\n');
        }
        System.out.print(sb);
    }
    
    public static int gcd(int A, int B){ 
        int max = Math.max(A,B);
        int min = Math.min(A,B);
        if(max % min == 0) return min;
        return gcd(min, max % min);
    }
    
}
