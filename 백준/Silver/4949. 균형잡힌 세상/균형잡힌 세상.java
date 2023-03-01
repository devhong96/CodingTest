import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while (true) {
            str = br.readLine();
            if (str.equals(".")) break;
            System.out.println(solve(str));
        }
    }

    private static String solve(String str) {

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty() || stack.peek() != '(') return "no";
                else stack.pop();
            } else if (c == ']') {
                if (stack.empty() || stack.peek() != '[') return "no";
                else stack.pop();
            }
        }
        if (stack.empty()) return "yes";
        else return "no";
    }
}