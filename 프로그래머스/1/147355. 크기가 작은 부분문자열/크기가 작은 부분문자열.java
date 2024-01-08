class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long standardNum = Long.parseLong(p);
        int offset = p.length() - 1;
        for(int i = 0; i < t.length() - offset; i++){
            long num = Long.parseLong(t.substring(i, i + p.length()));
            if(standardNum >= num){
                answer++;
            }
        }
        return answer;
    }
}