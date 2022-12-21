import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int avg =0;
        int[] arr = new int[5];

        for(int i=0; i < 5; i++){
            arr[i] = Integer.parseInt(br.readLine());
            avg += arr[i];
        }
        Arrays.sort(arr);

        System.out.println(avg/arr.length);
        System.out.println(arr[2]);
    }
}