import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < answer.length; i++){
            int[] line = commands[i];
            int from = line[0]-1;
            int to = line[1];
            int point = line[2]-1;
            
            int[] sub = Arrays.copyOfRange(array, from, to);
            Arrays.sort(sub);
            answer[i] = sub[point];
        }
        return answer;
    }
}