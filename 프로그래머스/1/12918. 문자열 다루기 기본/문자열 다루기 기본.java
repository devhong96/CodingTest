class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        int len = s.length();
        
        if(len ==4 || len== 6) answer = true;
        for(char c : s.toCharArray()){
            if(Character.isAlphabetic(c)) answer = false;
        }
        return answer;
    }
}