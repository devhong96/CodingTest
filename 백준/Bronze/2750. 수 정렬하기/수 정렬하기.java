import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];

        for(int i=0; i < count; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int s : arr) {
            System.out.println(s);
        }
    }
}