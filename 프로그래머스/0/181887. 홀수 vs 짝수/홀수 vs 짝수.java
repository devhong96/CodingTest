import java.math.*;

class Solution {
    public int solution(int[] numList) {
        
        int evenSum = 0, oddSum = 0;
        for(int i = 0; i < numList.length; i+=2){
            evenSum += numList[i];
        }
        
        for(int i = 1; i < numList.length; i+=2){
            oddSum += numList[i];
        }
        
        return Math.max(evenSum, oddSum);
    }
}