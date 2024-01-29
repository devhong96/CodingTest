import javax.security.auth.login.AccountException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.reflect.AnnotatedWildcardType;
import java.util.*;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Solution solution = new Solution();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        char [] chars = new char[count];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < count; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        solution.solution(length, count, chars);
    }
}

class Solution {
    static boolean[] visited;
    static int N;
    static char[] arr;
    public void solution(int length, int count, char[] chars) {

        N = length;
        visited = new boolean[count];
        arr = new char[count];
        for (int i = 0; i < count; i++) {
            arr[i] = chars[i];
        }

        Arrays.sort(arr);
        alphabet(0, 0, count);
    }

    public void alphabet(int index, int depth, int count){
        if (depth == N) {
            int con = 0;
            int vowel = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                if (visited[i]) {
                    sb.append((char) (arr[i]));

                    if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                        vowel++;
                    } else {
                        con++;
                    }
                }
            }
            if (con > 1 && vowel > 0) {
                System.out.println(sb);
            }
        }

        for(int i = index; i < count; i++){
            visited[i] = true;
            alphabet(i + 1,depth + 1, count);
            visited[i] = false;
        }
    }
}
