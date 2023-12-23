class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int index = s.length();
        boolean check = true;
        for (int i = 0; i < index; i++) {
            char c = s.charAt(i);
            if(!Character.isAlphabetic(c)) {
                answer.append(c);
                check = true;
            } else {
                if(check) {
                    answer.append(Character.toUpperCase(c));
                    check = false;
                } else {
                    answer.append(Character.toLowerCase(c));
                    check = true;
                }
            }
        }
        return answer.toString();
    }
}