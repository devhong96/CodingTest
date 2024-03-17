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
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        solution.solution(n, k);
    }
}

class Solution {
    static class State{
        final int point;
        final int step;
        private State(int point, int step) {
            this.point = point;
            this.step = step;
        }
    }

    public void solution(int n, int k) {

        Queue<State> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        queue.add(new State(n, 0));
        visited[n] = true;

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if(state.point == k){
                System.out.println(state.step);
                break;
            }

            for(int d = 0; d < 3; d++){
                int now = 0;
                if(d == 0) now = state.point + 1;
                if(d == 1) now = state.point - 1;
                if(d == 2) now = state.point * 2;

                if(now < 0 || now > 100000) continue;
                if(visited[now]) continue;

                visited[now] = true;
                queue.add(new State(now, state.step + 1));
            }
        }
    }
}
