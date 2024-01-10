class Solution {
    static final String[] words = {"aya", "ye", "woo", "ma"};
    static final String[] repeatWords = {"ayaaya", "yeye", "woowoo", "mama"};

    public boolean isBabbling(String word){
        for (int i = 0; i < words.length; i++) {
            word = word.replaceAll(repeatWords[i], "1").replaceAll(words[i]," ");
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