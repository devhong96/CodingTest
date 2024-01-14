import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int target = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int k = 0, answer = 0;

        for (int i = 1; i <= target; i++) {
            if (target % i == 0) {
                answer = i;
                k++;
                if (count == k) break;
            }
        }
        if(count > k){
            System.out.print(0);
        }else{
            System.out.print(answer);
        }
    }
}