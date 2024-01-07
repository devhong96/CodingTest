import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pick = nums.length/2;
        Set<Integer> set = new HashSet<>();
        for (int num : nums)set.add(num);
        if(set.size() >= pick) answer = pick;
        if(set.size() < pick) answer = set.size();
        return answer;
    }
}