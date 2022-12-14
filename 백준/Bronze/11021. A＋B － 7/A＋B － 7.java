import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int num = Integer.parseInt(br.readLine());
        
        for(int i=1;i<=num;i++){
            st = new StringTokenizer(br.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            
            bw.write("Case #"+i+": "+(A+B)+"\n");
        }
        br.close();
		bw.flush();
		bw.close();
    }
}