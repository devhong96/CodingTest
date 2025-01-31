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
        solution.solution(num);
    }
}

class Solution {
    public void solution(int num) {
        List<Integer> list = new ArrayList<>();

        boolean flag = false;
        int n;
        for (int i = 1; i <= num; i++) {
            n = 0;
            list.clear();

            int temp = i;

            while (temp > 0) {
                list.add(temp % 10);
                temp /= 10;
            }

            for (Integer integer : list) {
                n += integer;
            }

            if(n + i == num) {
                System.out.println(i);
                flag = true;
                break;
            }
        }
        if(!flag) {
            System.out.println(0);
        }
    }
}
