import java.util.*;

class Solution {
    public int[] solution(String s) {

        ArrayList<Integer> list = new ArrayList<>();
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("},\\{");

        Arrays.sort(arr, Comparator.comparingInt(String::length));

        for (String str : arr) {
            String[] split = str.split(",");

            for (String string : split) {
                int num = Integer.parseInt(string);
                if (!list.contains(num)) {
                    list.add(num);
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}