class Solution {
    public boolean solution(String s) {
    boolean answer = true;   
    int count = 0;
        
    if(s.length() == 4 || s.length() == 6){
        for(char c : s.toCharArray()){
            if(!Character.isDigit(c)) count++;
        }
        if(count==0) answer = true;
        else if(count>0) answer = false;  
        
    }else answer = false;
        
    return answer;
    }
}