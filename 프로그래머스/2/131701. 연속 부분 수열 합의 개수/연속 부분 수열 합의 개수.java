import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int[] doubleElements = new int[elements.length * 2];
        for(int a = 0; a < elements.length * 2; a++){
            doubleElements[a] = elements[a % elements.length];
        }

        Set<Integer> set = new HashSet<>();
        int offset = 0;
        while(true) {
            for (int i = 0; i < doubleElements.length - offset; i++) {
                int sum = 0;
                for (int k = 0; k <= offset; k++) {
                    sum += doubleElements[i + k];
                }
                set.add(sum);
            }
            if(elements.length - offset == 1) break;
            offset++;
        }
        return set.size();
    }
}