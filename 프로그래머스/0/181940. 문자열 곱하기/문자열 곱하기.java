import java.util.*;

class Solution {
    public String solution(String string, int k) {
        StringBuilder stringbuilder = new StringBuilder();
        for(int i = 0; i < k; i++){
            stringbuilder.append(string);
        }
        return stringbuilder.toString();
    }
}