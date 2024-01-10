class Solution {
    static final String[] words = {"aya", "ye", "woo", "ma"};
    static final String[] repeatWords = {"ayaaya", "yeye", "woowoo", "mama"};

    public boolean isBabbling(String word){
        for (String repeatWord : repeatWords) {
            word = word.replaceAll(repeatWord, "1");
        }
        
        for (String s : words) {
            word = word.replaceAll(s, " ");
        }
        return word.trim().isEmpty();
    }

    public int solution(String[] babbling) {
        int answer = 0;
        for(String word : babbling){
            if(isBabbling(word)) answer++;
        }
        return answer;
    }
}