import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
 
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            map.putIfAbsent(want[i], number[i]);
        }
        
        int answer = 0;
        for(int k = 0; k < discount.length - 9; k++){
       
            Map<String, Integer> dmap = new HashMap<>();
            
            for(int j = 0; j < 10; j++){
                dmap.putIfAbsent(discount[k + j], 0);
                dmap.put(discount[k + j], dmap.get(discount[k + j]) + 1);
            }
            
            Boolean isIdentical = true;
            
            for(String key : map.keySet()){
                if(map.get(key) != dmap.get(key)){
                    isIdentical = false;
                    break;
                }
            }
            answer += isIdentical ? 1 : 0;
        }
        return answer;
    }
}