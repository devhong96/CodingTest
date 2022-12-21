import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int total = Integer.parseInt(br.readLine());

        int[] arr = new int[total];

        for(int i=0; i < total; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int k=0 ; k<arr.length; k++) {
            sb.append(arr[k]);
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}