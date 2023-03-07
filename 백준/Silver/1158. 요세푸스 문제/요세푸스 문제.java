import java.util.*;
import java.io.*;

class Main {
    public StringBuilder solution(int n, int k){
        StringBuilder sb  = new StringBuilder();
        Queue<Integer> Q=new LinkedList<>();
        for (int i = 1; i <= n; i++) Q.offer(i);
        while (!Q.isEmpty()){
            for (int j = 1; j < k; j++) Q.offer(Q.poll());
            sb.append(Q.poll()).append(", ");
            if(Q.size() == 0){
                sb.delete(sb.length()-2, sb.length());
                break;
            }
        }
        return sb;
    }
    
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println("<"+T.solution(n, k)+">");
    }
}