class Solution {
    public int solution(int[] arrayA, int[] arrayB) {

        int gcdA = arrayA[0];
        for(int i = 1; i < arrayA.length; i++) {
            gcdA = getGcd(gcdA, arrayA[i]);

        }

        int gcdB = arrayB[0];
        for(int i = 1; i < arrayB.length; i++) {
            gcdB = getGcd(gcdB, arrayB[i]);
        }

        int answer = 0;

        boolean isGcdAValid = true;
        for (int num : arrayB) {
            if (num % gcdA == 0) {
                isGcdAValid = false;
                break;
            }
        }
        
        if (isGcdAValid) {
            answer = gcdA;
        }

        boolean isGcdBValid = true;
        for (int num : arrayA) {
            if (num % gcdB == 0) {
                isGcdBValid = false;
                break;
            }
        }
        
        if (isGcdBValid) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    public static int getGcd(int num1, int num2){
        if(num1 % num2 == 0) return num2;
        return getGcd(num2, num1 % num2);
    }
}