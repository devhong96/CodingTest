import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int[] snow = new int[9];
        for(int i = 0; i < snow.length; i++) {
            snow[i] = Integer.parseInt(br.readLine());
            sum += snow[i];
        }

        int diff = sum - 100;
        Arrays.sort(snow);
        int first = 0, second = 0;
        for (int i = 0; i < snow.length; i++) {
            for (int j = i + 1; j < snow.length; j++) {
                if(diff == snow[i] + snow[j]){
                    first = i;
                    second = j;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if(i != first && i != second)
                System.out.println(snow[i]);
        }
    }
}
