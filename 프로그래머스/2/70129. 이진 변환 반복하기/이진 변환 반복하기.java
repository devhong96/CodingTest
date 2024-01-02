class Solution {
    public int[] solution(String s) {
        int loop = 0;
        int zeros = 0;
    
        while(!s.equals("1")){
            int ones = 0;
            for(char c : s.toCharArray()){
                if(c =='0') zeros++;
                if(c =='1') ones++;
            }
            s = Integer.toString(ones, 2);
            loop++;
        }
        return new int[] {loop, zeros};
    }
}