class Solution {
    public int solution(int number) {
        
        long num= number;
        int count=0;

        do {
            if(num==1) return 0;
            if (count > 500) return -1;

            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num=num*3+1;
            }
            count++;

        } while (num!=1);
        return count;
    }
//        for (int i = 0; i < 500; i++) {
//            if(num==1) return i;
//            num = (num%2==0) ? num/2 : num*3+1;
//        }
//        return -1;
