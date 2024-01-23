import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int[] snow = new int[9];
        for (int i = 0; i < snow.length; i++) {
            snow[i] = Integer.parseInt(br.readLine());
            sum += snow[i];
        }

        int diff = sum - 100;
        Arrays.sort(snow);

        outerloop:
        for (int i = 0; i < snow.length; i++) {
            for (int j = i + 1; j < snow.length; j++) {
                if (diff == snow[i] + snow[j]) {
                    for (int k = 0; k < snow.length; k++) {
                        if (k != i && k != j) {
                            System.out.println(snow[k]);
                        }
                    }
                    break outerloop;
                }
            }
        }
    }
}
