import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int count = Integer.parseInt(st.nextToken());
            int[] arr = new int[count];

            for(int j = 0; j < arr.length; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            for (int j = 0; j < count; j++) {
                for (int k = j + 1; k <count; k++) {
                    sum += gcd(arr[j] , arr[k]);
                }
            }
            System.out.println(sum);
        }
    }

    public static int gcd(int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        if(max % min == 0) return min;
        return gcd(min, max % min);
    }
}