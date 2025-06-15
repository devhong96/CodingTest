import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.reverseOrder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        Solution solution = new Solution();

        for (int i = 0; i < 20; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(solution.solution(list));
    }
}

class Solution {
    public String solution(ArrayList<Integer> list) {

        ArrayList<Integer> w = new ArrayList<>();
        int ws = 0;
        ArrayList<Integer> k = new ArrayList<>();
        int ks = 0;

        for(int i = 0; i < 10; i++){
            w.add(list.get(i));
        }
        w.sort(reverseOrder());

        for (int i = 0; i < 3; i++) {
            ws+=w.get(i);
        }

        //
        for(int i = 10; i < 20; i++){
            k.add(list.get(i));
        }
        k.sort(reverseOrder());

        for (int i = 0; i < 3; i++) {
            ks+=k.get(i);
        }

        return ws + " " + ks;
    }
}