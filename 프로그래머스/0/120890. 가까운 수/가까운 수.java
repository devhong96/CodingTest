import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        
        int start = 0;
        int answer = 0;
        Arrays.sort(array);
        for(int i = 0; i < array.length; i++){
            if(Math.abs(n - array[0]) > Math.abs(n - array[i])){
                array[0] = array[i];
            }
        }
        return array[0];
    }
}