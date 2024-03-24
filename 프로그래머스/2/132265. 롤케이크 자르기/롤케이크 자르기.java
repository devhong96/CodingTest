import java.util.*;

class Solution {
    public int solution(int[] topping) {

        int answer = 0;
        HashMap<Integer, Integer> map2 = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for(int e : topping) {
            map2.put(e, map2.getOrDefault(e, 0) + 1);
        }

        for (int e : topping) {
            map1.put(e, map2.getOrDefault(e, 0) + 1);
            if(map2.get(e) == 1){
                map2.remove(e);
            } else {
                map2.put(e, map2.get(e) - 1);
            }
            if(map1.size() == map2.size()) answer++;
        }

        return answer;
    }
}