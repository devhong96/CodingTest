class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int bottle = 0;

        while(n >= a){
            bottle = (n / a);
            n = (n % a) + (bottle * b);
            answer += bottle * b;
        }
        return answer;
    }
}