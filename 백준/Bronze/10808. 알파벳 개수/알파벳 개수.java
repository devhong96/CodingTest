import java.util.*;
class Main {
    public void solution(String s){

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 97]++;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        T.solution(str);
    }
}
