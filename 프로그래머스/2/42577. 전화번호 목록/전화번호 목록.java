import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String s : phone_book){
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }
        
        for(String s : phone_book){
            for(int j = 1; j < s.length(); j++){
                if(map.containsKey(s.substring(0, j))) return false;
            }
        }
        return true;
    }
}