class Solution {
    public int[] solution(int brown, int yellow) {
        
        for(int width = 3; width<= 5000; width++){
            for(int height = 3; height <= width; height++){
                int boundary = (width*height-(width-2)*(height-2));
                int center = (width-2)*(height-2);
                
                if(brown==boundary&&yellow==center){
                    return new int[] {width, height};
                }
            }
        }
        
        return null;
    }
}