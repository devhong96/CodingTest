import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[5];
        int sum = 0, answer = 0;
        
        for(int i = 0; i<5; i++){
            num[i] = Integer.parseInt(br.readLine());
            if(num[i]>=40) sum+=num[i];
            else if(num[i]<40){
                num[i] = 40; 
                sum+=num[i];
            } 
        }
        answer = sum/5;
        System.out.println(answer);
    }
}


