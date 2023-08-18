import java.util.List;
import java.util.ArrayList;

class Solution {
    public double getSlope(int[] pointA, int[] pointB){
        return (double)(pointA[0] - pointB[0])/(pointA[1] - pointB[1]);
    }

    public int solution(int[][] dots) {
        List<Double> point = new ArrayList<>();

        point.add(getSlope(dots[0], dots[1]));
        point.add(getSlope(dots[2], dots[3]));

        point.add(getSlope(dots[0], dots[2]));
        point.add(getSlope(dots[1], dots[3]));

        point.add(getSlope(dots[0], dots[3]));
        point.add(getSlope(dots[1], dots[2]));

        System.out.println("point = " + point);

        for (int i = 0; i < point.size(); i+=2 ) {
            if(point.get(i).equals(point.get(i+1))) return 1;
        }
        return 0;
    }
}