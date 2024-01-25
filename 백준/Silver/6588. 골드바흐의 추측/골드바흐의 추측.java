import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.reflect.GenericDeclaration;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] prime = new boolean[1000000];

        for(int i = 1; i <= 1000001; i+=2){
            if(isPrime(i)){
                prime[i] = true;
            }
        }

        while(true){
            boolean isProve = false;
            int num = Integer.parseInt(br.readLine());
            for(int i = 3; i <= num; i++){
                if(prime[i] && prime[num - i]){
                    System.out.println(num + " = " + i + " + " + (num - i));
                    isProve = true;
                    break;
                }
            }
            if(num == 0) break;
            if(!isProve) System.out.println("Goldbach's conjecture is wrong.");
        }
    }

    static boolean isPrime(int num){
        for(int i = 3; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

}
