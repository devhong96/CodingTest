import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        System.out.print(calculator(num, 0));
    }
    static int calculator(int num, int count){
        if(num < 2) return count;

        return Math.min(calculator(num / 3,count + 1 + (num % 3)), calculator(num / 2,count + 1 + (num % 2)));
    }
}
