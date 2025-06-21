import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Solution solution = new Solution();

        st = new StringTokenizer(br.readLine(), " ");
        int total = Integer.parseInt(st.nextToken());

        char[] arr = new char[total];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < total; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        System.out.println(solution.solution(arr));
    }
}

class Solution {
    static boolean[] visited;
    static int length;
    static List<String> list = new ArrayList<>();
    static char[] c;
    public String solution(char[] arr) {

        StringBuilder sb = new StringBuilder();
        length = arr.length;
        visited = new boolean[10];
        c = arr;

        dfs(0, "");

        Collections.sort(list);

        sb.append(list.get(list.size() - 1)).append("\n");
        sb.append(list.get(0));

        return sb.toString();
    }

    public void dfs(int depth, String num) {

        if (depth == length + 1) {
            list.add(num);
            return;
        }

        for(int i = 0; i <= 9; i++) {
            if (visited[i]) continue;

            if(depth == 0 || isValid(num.charAt(depth - 1) - '0', i, c[depth - 1])) {
                visited[i] = true;
                dfs(depth + 1, num + i);
                visited[i] = false;
            }
        }
    }

    private boolean isValid(int a, int b, char op) {
        if (op == '<') return a < b;
        if (op == '>') return a > b;
        return false;
    }
}