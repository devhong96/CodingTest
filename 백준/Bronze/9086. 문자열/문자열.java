import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());

        for(int i = 0; i < count; i++){
            StringBuilder stringBuilder = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            String str = String.valueOf(st.nextToken());
            char c = str.charAt(0);
            char last = str.charAt(str.length() - 1);
            stringBuilder.append(c).append(last);
            System.out.println(stringBuilder);
        }
    }
}