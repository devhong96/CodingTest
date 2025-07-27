import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int N1 = Integer.parseInt(st.nextToken());

            int[] note1 = new int[N1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N1; j++) {
                note1[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int N2 = Integer.parseInt(st.nextToken());

            int[] note2 = new int[N2];
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < N2 ; k++) {
                note2[k] = Integer.parseInt(st.nextToken());
            }

            sb.append(solution.solution(note1, note2));

        }

        System.out.println(sb);
    }
}

class Solution {
    public String solution(int[] note1, int[] note2) {

        StringBuilder sb = new StringBuilder();
        HashSet<Integer> hset = new HashSet<>();

        for (int num : note1) {
            hset.add(num);
        }
        
        for (int num : note2) {
            if (hset.contains(num)) {
                sb.append(1).append('\n');
            } else sb.append(0).append('\n');
        }

        return sb.toString();
    }
}