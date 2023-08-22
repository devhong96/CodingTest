import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        int nowDays = 0;
        int finishedWork = 0;
        while(!queue.isEmpty()) {
            int index = queue.poll();
            int expiration = (int) Math.ceil(
                    (double) (100 - progresses[index]) / speeds[index]
            );
            if (expiration > nowDays) {
                if (nowDays != 0) {
                    result.add(finishedWork);
                    finishedWork = 0;
                }
                nowDays = expiration;
            }
            finishedWork++;
        }
        result.add(finishedWork);
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}