import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        int d = board.length;
        int width = moves.length;
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for(int m = 0; m < width; m++) {
            int x = moves[m] - 1;
            for(int y = 0; y < d; y++) {
                if(board[y][x] != 0){
                    int doll = board[y][x];
                    board[y][x] = 0;
                    if(!stack.isEmpty() && doll == stack.peek()){
                        answer += 2;
                        stack.pop();
                    } 
                    else {
                        stack.push(doll);
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}