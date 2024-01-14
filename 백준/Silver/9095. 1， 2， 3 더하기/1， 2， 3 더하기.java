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

        int[] arr = new int[11];        
        arr[1] = 1; arr[2] = 2; arr[3] = 4;
        int num = Integer.parseInt(st.nextToken());
        
        for(int i = 4; i <= 10; i++){
            arr[i] = arr[i-3] + arr[i - 2] + arr[i - 1];
        }
        
        for(int i = 0; i < num; i++){
            int a = Integer.parseInt(br.readLine());
            System.out.println(arr[a]);
        }
    }
}