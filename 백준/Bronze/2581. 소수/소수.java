import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int sum = 0, min = 0;;
        for(int i = a; i <= b; i++){
            if(isPrime(i)){
                sum += i;
            }
        }

        for(int i = a; i <= b; i++){
            if(isPrime(i)) {
                min = i;
                break;
            }
        }
        
        if(sum != 0) {
            System.out.println(sum);
            System.out.print(min);
        }else{
            System.out.println(-1);
        }
    }
    public static boolean isPrime(int n){
        if(n == 1 || n == 0) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}