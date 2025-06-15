import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Solution solution = new Solution();

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        System.out.println(solution.solution(n, k, l));
    }
}

class Solution {
    public String solution(int n, int k, int l) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(n);
        list.add(k);
        list.add(l);

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for(int i : list) {
            sb.append(i).append(" ");
        }

        return sb.toString().trim();
    }
}