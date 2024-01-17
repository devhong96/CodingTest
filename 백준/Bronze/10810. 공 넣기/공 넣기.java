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
        int line = Integer.parseInt(st.nextToken());

        int[] arr= new int[num];
        for(int i = 0; i < line; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for(int j = a - 1; j < b; j++){ // a - 1중요
                arr[j] = c;
            }
        }
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}