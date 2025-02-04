import java.util.*;

class Solution {
    private static class State {
        public final int x;
        public final int y;
        public final int step;
        
        public State(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    
    public static final int[] dx = {-1, 0, 1, 0};
    public static final int[] dy = {0, -1, 0, 1};
    
    public int[] findPosition(String[] board, char target) {
        for(int y = 0; y < board.length; y++){
            for(int x = 0; x < board[y].length(); x++){
                if(board[y].charAt(x) == target){
                    return new int[]{y, x};
                }
            }
        }
        return null;
    }
    
    public int solution(String[] board) {
        
        boolean[][] isVisited = new boolean[board.length][board[0].length()]; 
        
        int[] gPosition = findPosition(board, 'G');
        int gx = gPosition[1];
        int gy = gPosition[0];
        
        int[] rPosition = findPosition(board, 'R');
        int ry = rPosition[0];
        int rx = rPosition[1];
        
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(rx, ry, 0));
        isVisited[ry][rx] = true; 


        while(!queue.isEmpty()){
            State state = queue.poll();
            
            if(state.y == gy && state.x == gx) {
                return state.step;
            }
            
            for(int d = 0; d < 4; d++){
                int nx = state.x;
                int ny = state.y;
                
                while(true) {
                    int nextX = nx + dx[d];
                    int nextY = ny + dy[d];
                
                    if(nextY < 0 || nextY >= board.length || 
                       nextX < 0 || nextX >= board[nextY].length()
                      || board[nextY].charAt(nextX) == 'D') break;
                    
                    nx = nextX;
                    ny = nextY;
                    
                }
                
                if (!isVisited[ny][nx]) {
                    isVisited[ny][nx] = true;
                    queue.add(new State(nx, ny, state.step + 1));
                }
            }
        }
        return -1;
    }
}