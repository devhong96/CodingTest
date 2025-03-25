import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        for (String str : cities) {
            String lowerCase = str.toLowerCase();

            if (queue.contains(lowerCase)) {
                queue.remove(lowerCase);
                queue.add(lowerCase);
                answer++;
            } else {
                answer += 5;
                queue.add(lowerCase);
                if (queue.size() > cacheSize) queue.remove();
            }

        }
        return answer;
    }
}

