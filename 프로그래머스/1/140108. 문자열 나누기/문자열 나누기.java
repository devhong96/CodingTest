class Solution {
    public int solution(String s) {
        int answer = 1;// 이유 생각
        char standard = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if(count == 0){
                answer++;
                standard = s.charAt(i);
            }

            if(standard == s.charAt(i)) count++;
            if(standard != s.charAt(i)) count--;

        }
        return answer;
    }
}