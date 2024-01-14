import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int array = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int[] arr = new int[array + 1];

        for(int i = 1; i < arr.length; i++){
            arr[i] = i;
        }

        int offset = 0;

        for(int j = 0; j < count; j++){
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            offset = arr[a];
            arr[a] = arr[b];
            arr[b] = offset;
        }
        for(int k = 1; k < arr.length; k++){
            System.out.print(arr[k]+" ");
        }
    }
}