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

        int count = Integer.parseInt(st.nextToken());
        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            String[] data = new String[num];

            for (int j = 0; j < num; j++) {
                data[j] = br.readLine();
            }

            list.add(data);
        }

        System.out.print(solution.solution(list));
    }
}

class Solution {
    public String solution(List<String[]> list) {

        StringBuilder sb = new StringBuilder();

        for (String[] arr : list) {
            sb.append(isValid(arr)).append("\n");
        }

        return sb.toString();
    }

    private String isValid(String[] arr) {
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].startsWith(arr[i - 1])) {
                return "NO";
            }
        }
        return "YES";
    }
}
