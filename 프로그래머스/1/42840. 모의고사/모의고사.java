import java.util.*;

class Solution {
    private static final int[] first = {1, 2, 3, 4, 5};
    private static final int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] count(int[] answers){
        int firstPerson = 0, secondPerson = 0, thirdPerson = 0;
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == first[i % 5]) firstPerson++;
            if(answers[i] == second[i % 8]) secondPerson++;
            if(answers[i] == third[i % 10]) thirdPerson++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int max = Math.max(firstPerson, Math.max(secondPerson, thirdPerson));
        if(max == firstPerson) result.add(1);
        if(max == secondPerson) result.add(2);
        if(max == thirdPerson) result.add(3);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution(int[] answers) {
        return count(answers);
    }
}