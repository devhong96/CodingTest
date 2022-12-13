class Solution {
    public int solution(int n) {
        int answer=0;
        for(int i=1;i<=n;i++){
            if(2*i<=n) answer+=2*i;
        }
        return answer;
    }
}