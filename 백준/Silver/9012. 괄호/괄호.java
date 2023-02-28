import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < num; i++) {
            String answer = "YES";
            String str = br.readLine();

            for(char bracket : str.toCharArray()){
                if(bracket=='(') stack.push(bracket);
                else if(stack.empty()){
                    answer = "NO";
                }
                else stack.pop();
            }
            if(!stack.empty()) answer = "NO";
            System.out.println(answer);
            stack.clear();
        }
    }
}

