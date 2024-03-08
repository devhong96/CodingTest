class Solution {
    public int[] solution(int[] sequence, int k) {

        int lt = 0, sum = 0, len = 1000000;
        int[] answer = new int[2];

        for(int rt = 0; rt < sequence.length; rt++){

            sum += sequence[rt];
            if(sum == k){
                answer[0] = lt;
                answer[1] = rt;
                len = rt - lt;
            }

            while(sum > k){
                if(lt < sequence.length) {
                    sum -= sequence[lt++];
                    if (sum == k) {
                        if (len > rt - lt) {
                            answer[0] = lt;
                            answer[1] = rt;
                            len = rt - lt;
                        }
                    }
                }
            }
        }
        return answer;
    }
}