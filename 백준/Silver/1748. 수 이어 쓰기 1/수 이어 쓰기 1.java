import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int num = 10;
        int count = 0, point = 1;
        for(int i = 1; i <= target; i++){
            if(i % num == 0){
                num *= 10;
                point++;
            }
            count+=point;
        }
        System.out.println(count);
    }
}