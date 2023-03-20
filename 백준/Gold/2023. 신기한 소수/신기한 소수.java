import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int digit = Integer.parseInt(st.nextToken());

        DFS(2,1, digit);
        DFS(3,1, digit);
        DFS(5,1, digit);
        DFS(7,1, digit);
    }

    private static void DFS(int i, int n, int digit) {
        if(n == digit){
           if(isPrime(i)){
               System.out.println(i);
           }
           return;
        }

        for (int j = 1; j < 10; j++) {
            if(j % 2 == 0) continue;
            if(isPrime(i * 10 + j)){
                DFS(i * 10 + j, n+1, digit);
            }
        }
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j <= i/2; j++)
            if( i % j ==0)
                return false;
        return true;
    }
}