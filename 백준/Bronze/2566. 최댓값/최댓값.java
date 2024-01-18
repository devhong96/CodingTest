import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0, x = 1, y = 1;
        for(int i = 0; i < 9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                int point = Math.max(Integer.parseInt(st.nextToken()), answer);
                if(point > answer){
                    answer = point;
                    x = i+1;
                    y = j+1;
                }
            }
        }
        System.out.println(answer);
        System.out.print(x+" "+ y);
    }
}