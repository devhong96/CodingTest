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

        int num = Integer.parseInt(st.nextToken());
        int[] tree = new int[num];

        for(int i = 0; i < num; i++){
            tree[i] = Integer.parseInt(br.readLine());
        }
        int gcd = 0;
        for(int i = 0; i < num - 1;i++){
            int gap = tree[i + 1] - tree[i];
            gcd = gcd(gcd, gap);
        }

        int answer = (tree[num - 1] - tree[0]) / gcd - num + 1;
        System.out.print(answer);
    }

    public static int gcd(int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        while(min != 0){
            int r = max % min;
            max = min;
            min = r;
        }
        return max;
    }
}
