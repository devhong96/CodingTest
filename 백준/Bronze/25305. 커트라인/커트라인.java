import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[] arr = new int[total];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i < total; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(arr[total-count]);

    }
}