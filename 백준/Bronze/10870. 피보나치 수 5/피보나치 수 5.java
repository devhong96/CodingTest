import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        System.out.println(factorial(num));

    }

    static int factorial(int num) {
        if (num == 0) return 0;
        if (num == 1) return 1;

        return factorial(num-1) + factorial(num-2);
    }
}
