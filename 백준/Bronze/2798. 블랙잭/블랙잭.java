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
        int[] number = new int[count];
        int goal = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        for(int i = 0; i < count - 2; i++){
            for(int j = i + 1; j < count - 1; j++){
                for(int k = j + 1; k < count; k++){
                    int sum = number[i]+number[j]+number[k];
                    if(sum > goal) sum = 0; // 트릭 머리 속에 넣기
                    answer = Math.max(answer, sum);
                }
            }
        }
        System.out.print(answer);
    }
}