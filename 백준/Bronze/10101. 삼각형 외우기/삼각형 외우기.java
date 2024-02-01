import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Solution solution = new Solution();

        int[] angle = new int[3];

        for(int i = 0; i < 3; i++){
            angle[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(solution.solution(angle));
    }
}

class Solution {
    public String solution(int[] angle) {
        if(angle[0] + angle[1] + angle[2] != 180) {
            return "Error";
        }else if(angle[0] == angle[1] && angle[2] == angle[1] && angle[1] == angle[2]){
            return "Equilateral";
        }else if(angle[0] == angle[1] || angle[0] == angle[2] || angle[1] == angle[2]){
            return "Isosceles";
        }else{
            return "Scalene";
        }
    }
}
