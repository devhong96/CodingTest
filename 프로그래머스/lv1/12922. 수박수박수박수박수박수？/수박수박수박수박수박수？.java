class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
           String word = (i%2==0) ? "수" : "박";
            answer.append(word);
        }
        return answer.toString();
    }
}
