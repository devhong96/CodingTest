class Solution {
    public String solution(String my_string, int n) {
        
        String answer = "";
        String[] str= my_string.split("");
        
        for(int i = 0; i<str.length; i++){
            for(int j = 0; j<n; j++)
                answer+=str[i];       
        }
        return answer;
    }
}