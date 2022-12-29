class Solution {
    public int solution(int n) {
        
        int k=0;
        int[] arr = new int[n];
        
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                arr[k]=i;
                k++;
            }
        }
        return arr[0];
    }
}