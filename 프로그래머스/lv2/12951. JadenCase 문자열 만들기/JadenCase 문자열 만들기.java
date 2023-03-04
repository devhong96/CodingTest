class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str= s.toLowerCase().split("");
        boolean space = true;
        
        for(String string : str){
            answer += space ? string.toUpperCase() : string;
            space = string.equals(" ") ? true : false;
        }    
       return answer;
    }
}