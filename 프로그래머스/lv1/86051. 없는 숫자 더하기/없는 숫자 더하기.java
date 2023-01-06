class Solution {
    public int solution(int[] numbers) {
   
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int answer = 0;

        for (int k : arr) {
            for (int j : numbers) {
                if (k == j) arr[j] = 0;
            }
        }
        
        for (int j : arr) {
            answer += j;
        }
        return answer;
    }
}