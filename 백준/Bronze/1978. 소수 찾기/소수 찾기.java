import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st;
       
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < count; i++){
        int num = Integer.parseInt(st.nextToken());
            if(isPrime(num)) answer++;
        }
        System.out.println(answer);

    }
    public static boolean isPrime(int n){
        if(n == 1 || n == 0) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}