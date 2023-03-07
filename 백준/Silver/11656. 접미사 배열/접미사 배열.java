import java.io.*;
import java.util.*;

class Main {
    public void solution(String str){

        String[] arr = new String[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.substring(i);
        }
        
        Arrays.sort(arr);

        for (int i = 0; i < str.length(); i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();

        T.solution(str);
    }
}
