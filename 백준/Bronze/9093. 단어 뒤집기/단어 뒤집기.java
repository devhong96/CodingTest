import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        int num = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<num; i++){
            String str = br.readLine() + '\n';
            for(char c : str.toCharArray()){
                if(c == ' ' || c == '\n'){
                    while(!stack.isEmpty()){
                        bw.write(stack.pop());
                    }
                    bw.write(c);
                }else stack.push(c);
            }
        }
        bw.flush();
        bw.close();
    }
}

