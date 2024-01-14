import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int[] arr = new int[num];

        for(int n = 0; n < num; n++){
            arr[n] = n + 1;
        }

        int line = Integer.parseInt(st.nextToken());
        for(int i = 0; i < line; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            while(from < to){
                int offset = arr[from];
                arr[from++] = arr[to];
                arr[to--] = offset;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}