import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int[] A = new int[num];
        int[] B = new int[num];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < num; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < num; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solution.solution(A, B));
    }
}

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        ArrayList<Integer> list = new ArrayList<>();
        for (int j : B) {
            list.add(j);
        }

        for (int j : A) {
            Integer max = Collections.max(list);
            answer += j * max;
            list.remove(max);
        }
        return answer;
    }
}
