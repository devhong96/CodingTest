import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] ans = new int[26];
        Arrays.fill(ans, -1);

        String vocab = scan.nextLine();


        for(int i=0; i<vocab.length();i++){
            char answer = vocab.charAt(i);

            if(ans[answer-'a']==-1){
                ans[answer-'a']=i;
            }
        }

        for(int val: ans){
            System.out.print(val+" ");
        }

    }
}

