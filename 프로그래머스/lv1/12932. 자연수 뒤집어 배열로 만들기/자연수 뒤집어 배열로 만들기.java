class Solution {
   public int[] solution(long n) {

        String[] num = Long.toString(n).split("");
        int[] answer = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            answer[i] = (int) Long.parseLong(num[(answer.length - i - 1)]);
        }
        return answer;
    }
}