class Solution {
    boolean solution(String s) {
        
      boolean answer = true;
        int p = 0, y = 0;
        char[] chr = s.toUpperCase().toCharArray();

        for (char c : chr) {
            if (c == 'P') p++;
            if (c == 'Y') y++;
        }

        if (p != y) {
            answer = false;
        }
        return answer;
    }
}
