import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < num; i++){
            String s = br.readLine();

            if(s.contains("push")) {
                String[] number = s.split(" ");
                stack.push(Integer.parseInt(number[1]));
            }
            if(s.equals("pop")){
                if(!stack.empty()) bw.write(stack.pop()+"\n");
                else bw.write(-1+"\n");
            }
            if(s.equals("size"))
                bw.write(stack.size()+"\n");
            if(s.equals("empty")) {
                if(stack.empty()) bw.write(1+"\n");
                else bw.write(0+"\n");
            }
            if(s.equals("top")){
                if(stack.empty()) bw.write(-1+"\n");
                else bw.write(stack.peek()+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

