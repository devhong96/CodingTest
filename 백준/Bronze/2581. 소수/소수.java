import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0, min = -1;
        int from = Integer.parseInt(br.readLine());
        int to = Integer.parseInt(br.readLine());

        for (int i = from; i <= to; i++) {
            if (isPrime(i)) {
                answer += i;
                if(min == -1) min = i;
            }
        }
        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
            System.out.println(min);
        }
    }


    public static boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}