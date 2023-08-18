class Solution {
    public String solution(String str) {
        String result = "";

        for (char c : str.toCharArray()) {
            if (result.indexOf(c) == -1) {
                result += c;
            }
        }
        return result;
    }
}
