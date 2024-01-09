class Solution {
    public String solution(int[] food) {
        StringBuilder leftSide = new StringBuilder();
        for(int i = 1; i < food.length; i++){
            if(food[i] / 2  > 0){
                for(int k = 0; k < food[i] / 2; k++){
                    leftSide.append(String.valueOf(i));
                }
            }
        }
        String rightSide = new StringBuilder(leftSide).reverse().toString(); 
        return leftSide.append(0).append(rightSide).toString();
    }
}