import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            String s = br.readLine();

            if(s.contains("push")){
                String[] number = s.split(" ");
                queue.add(Integer.parseInt(number[1]));

            } else if(s.contains("pop")) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else sb.append("-1\n");

            } else if(s.contains("size")){
                sb.append(queue.size()).append("\n");

            } else if(s.contains("empty")) {
                if(!queue.isEmpty()) sb.append("0\n");
                else sb.append("1\n");

            } else if(s.contains("front")) {
                if(!queue.isEmpty()) sb.append(queue.peek()).append("\n");
                else sb.append("-1\n");

            } else if(s.contains("back")) {
                if(queue.isEmpty()){
                    sb.append("-1\n");
                } else {
                    int n = queue.size();
                    for (int j = 1; j <= n - 1; j++) {
                        queue.add(queue.remove());
                    }
                    sb.append(queue.peek()).append("\n");
                    queue.add(queue.remove());
                }
            }
        }
        System.out.print(sb);
    }
}
