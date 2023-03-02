class Solution {
    public long solution(long price, long money, long count) {
        
        long answer = -1;
        long totalprice = price*count*(count+1)/2;
        
        if(totalprice > money) answer = totalprice - money;
        else answer = 0;
        
        return answer;
    }
}