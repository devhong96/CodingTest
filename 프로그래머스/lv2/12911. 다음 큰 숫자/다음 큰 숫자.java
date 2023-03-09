class Solution {
    public int solution(int n) {
        int answer = 0;
        int pcount = 0, count = 0;

        String snum = Integer.toBinaryString(n);


        for(int j = 0; j<snum.length(); j++){
            if(snum.charAt(j)=='1') count++;
        }

        for(answer = n+1; ; answer++){
            String compare = Integer.toBinaryString(answer);
            pcount = 0;
            for (int k = 0; k < compare.length(); k++) {
                if(compare.charAt(k) == '1'){
                    pcount++;
                }
            }
            if(count == pcount) break;
        }
        return answer;
    }
}