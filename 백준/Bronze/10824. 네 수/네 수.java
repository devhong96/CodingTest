import java.io.*;
import java.util.*;

class Main {
    public long solution(int A, int B, int C, int D){

        String a = Integer.toString(A);
        String b = Integer.toString(B);

        String c = Integer.toString(C);
        String d = Integer.toString(D);

        long num1 = Long.parseLong(a+b);
        long num2 = Long.parseLong(c+d);

        return num1 + num2;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A =  Integer.parseInt(st.nextToken());
        int B =  Integer.parseInt(st.nextToken());
        int C =  Integer.parseInt(st.nextToken());
        int D =  Integer.parseInt(st.nextToken());

        System.out.println(T.solution(A,B,C,D));
    }
}
