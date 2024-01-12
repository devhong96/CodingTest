import java.util.*;

class Solution {
    public static final String [] words = {"A", "E", "I", "O", "U"};
    public static List<String> list = new ArrayList<>();
    public int solution(String word) {        
        int answer = 0;
        int wordLen = word.length();
        dfs(0, "");
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
            }
        }
        
        
        return answer;
    }
    public void dfs(int length, String str){
        list.add(str);
        if(length == 5) return;
        for(int i = 0; i < 5; i++) 
            dfs(length + 1, str + words[i]);
    }
}