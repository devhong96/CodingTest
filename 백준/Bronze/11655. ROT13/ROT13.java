import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        for(char c : str.toCharArray()){
            if(Character.isUpperCase(c)){
                if((c + 13) > 'Z'){
                    sb.append((char)(c - 13));
                } else sb.append((char)(c + 13));
            }

            if(!Character.isUpperCase(c) && c != ' ' && !Character.isDigit(c)) {
                if((char) (c + 13) > 'z'){
                    sb.append((char)(c - 13));
                } else sb.append((char)(c + 13));
            }
            if(c == ' ') sb.append(' ');

            if(Character.isDigit(c)) sb.append(c);
        }
        System.out.print(sb);
    }

}
