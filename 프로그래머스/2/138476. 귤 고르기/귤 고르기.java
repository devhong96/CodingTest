import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : tangerine){
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i)+1);
        }
        List<Integer> entries = new ArrayList<>(map.keySet());
        entries.sort((n1, n2) -> map.get(n2).compareTo(map.get(n1)));
        
        for(Integer i : entries){
            if(k <= 0) break;
            answer++;
            k -=map.get(i);
        }
            
        return answer;
    }
}