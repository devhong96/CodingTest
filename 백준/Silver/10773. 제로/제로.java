import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < num; i++){
            int n = Integer.parseInt(br.readLine());

            if(n == 0) stack.pop();
            else stack.push(n);
        }

        int sum = 0;
        for(int j : stack){
            sum+=j;
        }
        System.out.println(sum);
    }
}

